public class Successor
{
    public static BSTNode findSuccessor(BSTNode node)
    {
        if (node.right == null)
            return findParentSuccessor(node.value, node);
        else
            return findMin(node.right);
    }

    public static BSTNode findParentSuccessor(int key, BSTNode node)
    {
        // here key should be < its successor
        while (node != null && key >= node.value)
            node = node.parent;
        return node;
    }

    public static BSTNode findMin(BSTNode root)
    {
        BSTNode tmp = root;
        while (tmp.left != null)
            tmp = tmp.left;
        return tmp;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6,7};
        MinimalTree mt = new MinimalTree();
        BSTNode root = mt.buildMinimalTree(A);
        BSTNode query1 = root.right;
        BSTNode query2 = root.left;
        BSTNode query3 = root.right.right;

        System.out.format("%s successor is %s\n", query1, findSuccessor(query1));
        System.out.format("%s successor is %s\n", query2, findSuccessor(query2));

        BSTNode query3Successor = findSuccessor(query3);
        if (query3Successor == null)
            System.out.format("%s successor is null\n", query3);
        else
            System.out.format("%s successor is %s\n", query3, findSuccessor(query3));
    }
}