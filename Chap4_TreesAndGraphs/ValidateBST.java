public class ValidateBST
{
    private static Integer lastVisited = null;

    public static boolean checkBSTInOrder(BSTNode root)
    {
        if (root == null) return true;
        if (!checkBSTInOrder(root.left)) return false;
        if (lastVisited != null && root.value <= lastVisited) return false;
        lastVisited = root.value;
        if (!checkBSTInOrder(root.right)) return false;
        return true;
    }

    public static boolean checkBSTPreOrder(BSTNode root)
    {
        return checkBSTPreOrder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkBSTPreOrder(BSTNode root, int min, int max)
    {
        if (root == null) return true;
        if (min > root.value || root.value >= max) return false;
        if (!checkBSTPreOrder(root.left, min, root.value)) return false;
        if (!checkBSTPreOrder(root.right, root.value, max)) return false;
        return true;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6,7};
        MinimalTree mt = new MinimalTree();
        BSTNode root = mt.buildMinimalTree(A);

        System.out.format("in-order --------------\n");
        BSTNode.printTree(root);
        System.out.println();
        System.out.format("is BST ? %b\n", checkBSTInOrder(root));
        System.out.format("-------------\n");

        BSTNode rootNotBST = new BSTNode(2);
        rootNotBST.left = new BSTNode(3);
        rootNotBST.right = new BSTNode(1);
        BSTNode.printTree(rootNotBST);
        System.out.println();
        System.out.format("is BST ? %b\n", checkBSTInOrder(rootNotBST));

        System.out.format("pre-order --------------\n");
        BSTNode.printTree(root);
        System.out.println();
        System.out.format("is BST ? %b\n", checkBSTPreOrder(root));
        System.out.format("-------------\n");
        BSTNode.printTree(rootNotBST);
        System.out.println();
        System.out.format("is BST ? %b\n", checkBSTPreOrder(rootNotBST));
    }
}