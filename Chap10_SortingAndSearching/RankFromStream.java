import java.util.LinkedList;

public class RankFromStream
{
    public Node root;

    public class Node
    {
        public int value;
        public int size;
        public Node left, right;

        Node(int value)
        {
            this.value = value;
            size = 1;
        }
    }

    public void put(int key)
    {
        root = put(root, key);
    }

    public Node put(Node x, int key)
    {
        if (x == null)
            return new Node(key);
        else
        {
            if (key < x.value)
                x.left = put(x.left, key);
            else if (key > x.value)
                x.right = put(x.right, key);
            else
                x.value = key;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int size(Node x)
    {
        if (x == null)
            return 0;
        else
            return x.value;
    }

    public int rank(int key)
    {
        return rank(root, key);
    }

    public int rank(Node x, int key)
    {
        // it is fine to report rank=0 or n for a key that is not in BST
        if (x == null) return 0;

        if (key < x.value)
            return rank(x.left, key);
        else if (key > x.value)
            return 1 + size(x.left) + rank(x.right, key);
        else
            return size(x.left);
    }

    public void print()
    {
        print(root);
        System.out.println();
    }

    private
    void print(Node x)
    {
        if (x == null) { return; }
        print(x.left);
        System.out.format("%d ", x.value);
        print(x.right);
    }

    public static void main(String[] args)
    {
        RankFromStream bst = new RankFromStream();
        int[] A = {5,1,4,4,5,9,7,13,3};
        for (int i=0; i<A.length; i++)
        {
            bst.put(A[i]);
        }

        bst.print();

        System.out.format("get rank of num %d is %d\n", 1, bst.rank(1));
        System.out.format("get rank of num %d is %d\n", 3, bst.rank(3));
        System.out.format("get rank of num %d is %d\n", 4, bst.rank(4));
    }
}