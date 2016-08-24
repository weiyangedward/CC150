public class BSTNode
{
    public int value;
    public BSTNode left;
    public BSTNode right;
    public BSTNode parent;

    public BSTNode(int value, BSTNode parent)
    {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = parent; // root node should have parent=null
    }

    public static BSTNode put(BSTNode parent, BSTNode root, int value)
    {
        if (root == null) return new BSTNode(value, parent);

        if (value < root.value)
            root.left = put(root, root.left, value);
        else if (value > root.value)
            root.right = put(root, root.right, value);
        else
            root.value = value;

        return root;
    }

    public static void printTree(BSTNode root)
    {
        if (root == null) return;
        printTree(root.left);
        System.out.format("%d ", root.value);
        printTree(root.right);
    }

    public String toString()
    {
        return String.valueOf(value);
    }
}