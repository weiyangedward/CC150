public class CheckSubtree
{
    private static boolean startComparison = false;
    public static boolean checkSubtree(BSTNode root1, BSTNode root2)
    {
        // both are leaves, return true
        if (root1 == null && root2 == null)
            return true;
        // if one tree is done while the other is not, return false
        else if (root1 == null)
            return false;
        else if (root2 == null)
            return false;
        // both are not done
        else
        {
            if (root1.value != root2.value)
            {
                if (startComparison)
                    return false;

                // keep looking for matched root
                if (root1.value < root2.value)
                    return checkSubtree(root1.right, root2);
                else
                    return checkSubtree(root1.left, root2);
            }
            // node value matched
            else
            {
                // first-time match, start comparison
                if (!startComparison)
                    startComparison = true;

                boolean isLeftTheSame = checkSubtree(root1.left, root2.left);
                boolean isRightTheSame = checkSubtree(root1.right, root2.right);
                return isLeftTheSame && isRightTheSame;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A1 = {1,2,3,4,5,6,7};
        int[] A2 = {1,2,3};
        MinimalTree mt = new MinimalTree();
        BSTNode root1 = mt.buildMinimalTree(A1);
        BSTNode root2 = mt.buildMinimalTree(A2);
        System.out.format("tree1 -------------\n");
        root1.printLevel();
        System.out.format("tree2 -------------\n");
        root2.printLevel();
        System.out.format("is tree2 a subtree of tree1 ? %b\n", checkSubtree(root1, root2));

        System.out.format("----------------\n");
        int[] A3 = {1,2,3,4};
        BSTNode root3 = mt.buildMinimalTree(A3);
        System.out.format("tree3 -------------\n");
        root3.printLevel();
        System.out.format("is tree3 a subtree of tree1 ? %b\n", checkSubtree(root1, root3));
    }
}