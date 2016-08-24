import java.util.LinkedList;

public class BSTNode
{
    public int value;
    public int size;
    public BSTNode left;
    public BSTNode right;
    public BSTNode parent;

    public BSTNode(int value, BSTNode parent)
    {
        this.value = value;
        this.size = 1; // a new node has size = 1
        this.left = null;
        this.right = null;
        this.parent = parent; // root node should have parent=null
    }

    public BSTNode put(BSTNode parent, BSTNode root, int value)
    {
        if (root == null) return new BSTNode(value, parent);

        if (value < root.value)
            root.left = put(root, root.left, value);
        else if (value > root.value)
            root.right = put(root, root.right, value);
        else
            root.value = value;

        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    public boolean find(BSTNode root, int key)
    {
        if (root == null) return false;
        BSTNode tmp = root;
        while (tmp != null)
        {
            if (tmp.value == key)
                return true;
            else if (tmp.value < key)
                tmp = tmp.right;
            else
                tmp = tmp.left;
        }
        return false;
    }

    /**
     * O(1)
     * @param x
     * @return
     */
    public static
    int size(BSTNode x)
    {
        if (x == null) { return 0; }
        return x.size;
    }

    private
    BSTNode min(BSTNode x)
    {
        if (x == null) { return null; }
        BSTNode t = x;
        while (t.left != null)
        { t = t.left; }
        return t;
    }

    private
    BSTNode deleteMin(BSTNode x)
    {
        // if x.left is null, then replace x with x.right
        if (x.left == null) { return x.right; }

        x.left = deleteMin(x.left);

        // update the count after deleted min
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public BSTNode delete(BSTNode root, int key)
    {
        if (root == null) return null;

        if (root.value == key)
        {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;

            BSTNode tmp = root;
            root = min(tmp.right);
            root.right = deleteMin(tmp.right);
            root.left = tmp.left;
        }
        root.size = 1 + size(root.left) + size(root.right);
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

    public void printLevel()
    {
        ListOfDepths                    ld    = new ListOfDepths();
        LinkedList<LinkedList<BSTNode>> lists = ld.createLevelLinkedList(this);
        ListOfDepths.printLevelLinkedList(lists);
    }
}