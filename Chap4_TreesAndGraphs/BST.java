import java.util.Random;

public class BST
{
    public BSTNode root;
    public int size;

    public BST()
    {}

    public BST(int[] A)
    {
        for (int i=0; i<A.length; i++)
            put(A[i]);
        size = A.length;
    }

    public void put(int value)
    {
        if (root == null)
            root = new BSTNode(value, null);
        else
            root = root.put(null, root, value);
        size++;
    }

    public boolean find(int key)
    {
        return root.find(root, key);
    }

    public BSTNode delete(int key)
    {
        return root.delete(root, key);
    }

    public BSTNode getRandomNode()
    {
        Random rand = new Random();
        // index in [1, size]
        int index = rand.nextInt(size)+1;
        return getRandomNode(root, index);
    }

    public BSTNode getRandomNode(BSTNode root, int index)
    {
        if (BSTNode.size(root.left)+1 == index)
            return root;
        else if (BSTNode.size(root.left)+1 > index)
            return getRandomNode(root.left, index);
        else
            return getRandomNode(root.right, index-BSTNode.size(root.left)-1);
    }

    public void printLevel()
    {
        root.printLevel();
    }

    public static void main(String[] args)
    {
        try
        {
            int[] A   = {4, 2, 6, 1, 5, 3, 7};
            BST   bst = new BST(A);
            bst.printLevel();
            for (int i = 0; i < 10; i++)
            {
                System.out.format("trial %d\n", i);
                System.out.format("random node: %s\n", bst.getRandomNode());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}