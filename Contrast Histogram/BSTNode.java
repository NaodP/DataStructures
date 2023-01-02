

public class BSTNode<E extends Comparable<Pixel>> {
    /* ATTRIBUTES */
    public Pixel data;
    public BSTNode<Pixel> leftChild, rightChild;

    /* CONSTRUCTORS */
    public BSTNode(){};
    public BSTNode(Pixel data){
        this.data = data;
    }

    /* METHODS */
    @Override
    public String toString(){
        String values = "";
        values += data;
        return values;
    }
};