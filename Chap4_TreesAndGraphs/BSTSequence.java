import java.util.LinkedList;

public class BSTSequence
{
    /**
     * return all possible order to insert nodes to generate a given BST
     * time = O(n) for post-order traversal
     * time = O(n^3) in total
     * @param root
     * @return
     */
    public static LinkedList<LinkedList<Integer>> getBSTSequence(BSTNode root)
    {
        if (root == null) return new LinkedList<LinkedList<Integer>>();

        LinkedList<LinkedList<Integer>> leftList = getBSTSequence(root.left);
        LinkedList<LinkedList<Integer>> rightList = getBSTSequence(root.right);

        LinkedList<LinkedList<Integer>> weaveList;
        if (!leftList.isEmpty() && !rightList.isEmpty())
            weaveList = weave(leftList, rightList);
        else if (!leftList.isEmpty())
            weaveList = rightList;
        else if (!rightList.isEmpty())
            weaveList = leftList;
        // both list are empty at leaf node, create an empty weaveList
        else
        {
            weaveList = new LinkedList<LinkedList<Integer>>();
            weaveList.add(new LinkedList<Integer>());
        }

        for (LinkedList<Integer> list : weaveList)
            list.addFirst(root.value);
        return weaveList;
    }

    /**
     * for list (a,b) and (c,d), return (a,b,c,d) and (c,d,a,b)
     * time O(n^2)
     * @param leftList
     * @param rightList
     * @return
     */
    private static LinkedList<LinkedList<Integer>> weave(LinkedList<LinkedList<Integer>> leftList, LinkedList<LinkedList<Integer>> rightList)
    {
        LinkedList<LinkedList<Integer>> weaveList = new LinkedList<LinkedList<Integer>>();

        for (LinkedList<Integer> list1 : leftList)
        {
            for (LinkedList<Integer> list2 : rightList)
            {
                LinkedList<Integer> tmp1 = new LinkedList<Integer>(list1);
                tmp1.addAll(list2);
                weaveList.add(tmp1);

                LinkedList<Integer> tmp2 = new LinkedList<Integer>(list2);
                tmp2.addAll(list1);
                weaveList.add(tmp2);
            }
        }
        return weaveList;
    }

    public static void main(String[] args)
    {
        try
        {
            int[]                           A        = {1, 2, 3, 4, 5, 6, 7};
            MinimalTree                     mt       = new MinimalTree();
            BSTNode                         root     = mt.buildMinimalTree(A);
            LinkedList<LinkedList<Integer>> sequence = getBSTSequence(root);
            for (LinkedList<Integer> list : sequence)
            {
                for (Integer i : list)
                {
                    System.out.format("%d ", i);
                }
                System.out.println();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}