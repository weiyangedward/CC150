public class MinimalTree
{
    public BSTNode buildMinimalTree(int[] A)
    {
        BSTNode root = buildMinimalTree(A, 0, A.length-1, null);
        return root;
    }

    public BSTNode buildMinimalTree(int[] A, int s, int e, BSTNode parent)
    {
        if (s > e) return null;
        int mid = s + (e-s)/2;
        BSTNode root = new BSTNode(A[mid], parent);
        root.left = buildMinimalTree(A, s, mid-1, root);
        root.right = buildMinimalTree(A, mid+1, e, root);
        return root;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6,7};
        MinimalTree mt = new MinimalTree();
        BSTNode root = mt.buildMinimalTree(A);
        BSTNode.printTree(root);
        System.out.println();
    }
}