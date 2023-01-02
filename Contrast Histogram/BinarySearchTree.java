public class BinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeInterface<E>{

    /* ATTRIBUTES */
    public BSTNode<Pixel> root;

    /* CONSTRUCTORS */
    public BinarySearchTree(){};
    public BinarySearchTree(BSTNode<Pixel> root){
        this.root = root;
    };

    /* METHODS */
    @Override
    public BSTNode<Pixel> search(Pixel target){
        if(root == null) return null;
        else if(root.data.compareTo(target)==0) return root;
        
        BSTNode<Pixel> left = searchPrivate(target, root.leftChild);
        BSTNode<Pixel> right = searchPrivate(target, root.rightChild);

        if(left != null && left.data.compareTo(target)==0) return left;
        return right;
    };
    private BSTNode<Pixel> searchPrivate(Pixel target, BSTNode<Pixel> temp){
        if(temp == null) return null;
        if(temp.data.compareTo(target)==0) return temp;

        BSTNode<Pixel> left = searchPrivate(target, temp.leftChild);
        BSTNode<Pixel> right = searchPrivate(target, temp.rightChild);

        if(left != null && left.data.compareTo(target)==0) return left;
        return right;
    };

    @Override
    public void inorderTraversal(int total){
        int num = inorderTraversalPrivate(root, 0, total);
        return;
    };
    private int inorderTraversalPrivate(BSTNode<Pixel> temp, int count, int total){
        if(temp == null) return count;

        double newIntensity;

        temp.data.cummulativeGreater = inorderTraversalPrivate(temp.leftChild, count, total) + temp.data.count;
        newIntensity = ((float)temp.data.cummulativeGreater / (float)total) * 255.0;
        temp.data.adjustedIntensity = (int) newIntensity;

        return inorderTraversalPrivate(temp.rightChild, temp.data.cummulativeGreater, total);
    };

    @Override
    public boolean add(Pixel item){
        BSTNode<Pixel> newNode = new BSTNode<Pixel>(item);
        if (root == null) root = newNode;
        else{
            BSTNode<Pixel> tempNode = root;
            int value = 0;
            while(tempNode != null){
                value = newNode.data.compareTo(tempNode.data);
                if(value > 0){
                    if(tempNode.rightChild == null){
                        tempNode.rightChild = newNode;
                        return true;
                    }
                    else tempNode = tempNode.rightChild;
                }
                else{
                    if(tempNode.leftChild == null){
                        tempNode.leftChild = newNode;
                        return true;
                    }
                    else tempNode = tempNode.leftChild;
                }
            }
        }
        return false;
    };

    @Override
    public int height(){
        return heightPrivate(root);
    };
    private int heightPrivate(BSTNode<Pixel> node){
        if(node == null) return 0;
        return 1 + Math.max(heightPrivate(node.leftChild), heightPrivate(node.rightChild));
    };
};