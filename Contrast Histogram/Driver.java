/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Contrast Equalization
* Due Date: 10/14/2022
* File: Driver.java
* Description: Contrast Equalization
*/

import java.util.*;

class Driver{
    public static void main(String[] args){
        /* VARIABLES */
        int rows, cols, totalNodes = 0;
        ArrayList<Integer> allIntensities = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        BinarySearchTree<Pixel> tree = new BinarySearchTree<>();

        /* GET INPUT */
        rows = keyboard.nextInt();
        cols = keyboard.nextInt();

        /* ADD PIXELS TO TREE */
        for(int i = 0; i < rows*cols; i++){
            Pixel newPixel = new Pixel(keyboard.nextInt());
            BSTNode<Pixel> searchedNode = tree.search(newPixel);

            //If Pixel Intensity Is Already In Tree
            if(searchedNode != null && searchedNode.data.intensity == newPixel.intensity){
                searchedNode.data.count++;
            }
            else{
                allIntensities.add(newPixel.intensity);
                totalNodes++;
                tree.add(newPixel);
            }
        }

        tree.inorderTraversal(rows*cols);
        System.out.println("Height: " + tree.height());
        System.out.println("Total Number of Nodes: " + totalNodes);
        outputAdjustedHistogram(tree, totalNodes, allIntensities);

        keyboard.close();
    };

    public static void outputAdjustedHistogram(BinarySearchTree<Pixel> tree, int totalNodes, ArrayList<Integer> allIntensities){
        System.out.println("INTENSITY HISTOGRAM");
        System.out.println("  Intensity Range          Pixel Count          Markers  ");
        for(int i = 0; i < 255; i+=16){
            int count = 0;
            for(int j = 0; j < totalNodes; j++){
                BSTNode<Pixel> returned = tree.search(new Pixel(allIntensities.get(j)));
                if(returned == null) continue;
                if(returned.data.adjustedIntensity >= i && returned.data.adjustedIntensity < i+15){
                    count += returned.data.count;
                }
            }
            System.out.printf("       %d-%d                   %d                 ", i, i+15, count);
            for(int j = 0; j < count; j+=20){
                System.out.print('*');
            }
            System.out.print('\n');
        };
    };
};