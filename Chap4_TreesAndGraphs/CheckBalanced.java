import java.util.LinkedList;

public class CheckBalanced
{
    public int checkBalanced(BSTNode root)
    {
        if (root == null) return -1;

        int leftHeight = checkBalanced(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkBalanced(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(BSTNode root)
    {
        int height = checkBalanced(root);
        return height != Integer.MIN_VALUE;
    }

    public static void main(String[] args)
    {
        CheckBalanced cb = new CheckBalanced();
        int[] A = {1,2,3,4,5,6,7};
        MinimalTree mt = new MinimalTree();
        BSTNode root = mt.buildMinimalTree(A);
        BSTNode.printTree(root);
        System.out.format("is BST balanced ? %b\n", cb.isBalanced(root));
        System.out.format("----------------\n");
        root = BSTNode.put(root, 8);
        root = BSTNode.put(root, 9);
        ListOfDepths                    ld    = new ListOfDepths();
        LinkedList<LinkedList<BSTNode>> lists = ld.createLevelLinkedList(root);
        ListOfDepths.printLevelLinkedList(lists);
        System.out.format("is BST balanced ? %b\n", cb.isBalanced(root));
    }
}