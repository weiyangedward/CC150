public class FirstCommonAncestor
{
    public static BSTNode firstCommonAncestor(BSTNode root, BSTNode query1, BSTNode query2)
    {
        int min = (query1.value < query2.value) ? query1.value : query2.value;
        int max = (query1.value < query2.value) ? query2.value : query1.value;

        return findCommonAncestor(root, min, max);
    }

    public static BSTNode findCommonAncestor(BSTNode root, int min, int max)
    {

        if (root == null) return null;

        // when root.value equals to min or max, then one of the two nodes are their common ancestor
        if (root.value == min || root.value == max) return root;

        if (min < root.value && root.value < max)
            return root;

        if (min > root.value)
            return findCommonAncestor(root.right, min, max);
        if (max < root.value)
            return findCommonAncestor(root.left, min, max);

        return null;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6,7};
        MinimalTree mt = new MinimalTree();
        BSTNode root = mt.buildMinimalTree(A);
        root.printLevel();
        BSTNode query1 = root.right.right;
        BSTNode query2 = root.right.left;
        System.out.format("node %s and %s first common ancestor is %s\n", query1, query2, firstCommonAncestor(root, query1, query2));

        query1 = root.right.right;
        query2 = root.left.left;
        System.out.format("node %s and %s first common ancestor is %s\n", query1, query2, firstCommonAncestor(root, query1, query2));
    }
}