import java.util.LinkedList;

public class ListOfDepths
{
    public
    LinkedList<LinkedList<BSTNode>> createLevelLinkedList(BSTNode root)
    {
        LinkedList<LinkedList<BSTNode>> lists = new LinkedList<LinkedList<BSTNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    /**
     * add nodes to level linked lists
     * @param root
     * @param lists
     * @param level
     */
    public void createLevelLinkedList(BSTNode root, LinkedList<LinkedList<BSTNode>> lists, int level)
    {
        if (root == null) return;
        // if this is new level, add a new linked list to lists
        if (lists.size() == level)
        {
            LinkedList<BSTNode> levelList = new LinkedList<BSTNode>();
            levelList.add(root);
            lists.add(levelList);
        }
        else
        {
            lists.get(level).add(root);
        }
        createLevelLinkedList(root.left, lists, level+1);
        createLevelLinkedList(root.right, lists, level+1);
    }

    public static void printLevelLinkedList(LinkedList<LinkedList<BSTNode>> lists)
    {
        for (int i=0; i<lists.size(); i++)
        {
            System.out.format("level %d: ", i);
            for (int j=0; j<lists.get(i).size(); j++)
            {
                System.out.format("%d ", lists.get(i).get(j).value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6,7};
        MinimalTree mt = new MinimalTree();
        BSTNode root = mt.buildMinimalTree(A);
        ListOfDepths ld = new ListOfDepths();
        LinkedList<LinkedList<BSTNode>> lists = ld.createLevelLinkedList(root);
        printLevelLinkedList(lists);
    }
}