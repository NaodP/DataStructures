

public interface BinarySearchTreeInterface <E extends Comparable<E>>{
    /* METHODS */
    public BSTNode<Pixel> search(Pixel target);
    public void inorderTraversal(int total);
    public boolean add(Pixel item);
    public int height();
};