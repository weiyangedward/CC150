import java.util.HashMap;

public class PathsWithSum
{
    private int pathsNum;
    private HashMap<Integer, Integer> seenSum;
    private int target;
    public PathsWithSum(BSTNode root, int target)
    {
        seenSum = new HashMap<Integer, Integer>();
        seenSum.put(0, 1); // a path is found when target == currentSum
        this.target = target;
        getPathWithSum(root, 0);
    }

    public void getPathWithSum(BSTNode root, int lastSum)
    {
        if (root == null) return;
        int currentSum = root.value + lastSum;
        if (seenSum.containsKey(currentSum-target) && seenSum.get(currentSum-target) > 0)
        {
            pathsNum+=seenSum.get(currentSum-target); // add to pathsNum the all paths that sum to target
        }
        if (!seenSum.containsKey(currentSum))
            seenSum.put(currentSum, 0);
        // increament path count
        seenSum.put(currentSum, seenSum.get(currentSum)+1);
        getPathWithSum(root.left, currentSum);
        getPathWithSum(root.right, currentSum);
        // decreament path count (roll-back) after a path is done
        seenSum.put(currentSum, seenSum.get(currentSum)-1);
    }

    public int getPathsNum()
    {
        return pathsNum;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6,7};
        MinimalTree mt = new MinimalTree();
        BSTNode root = mt.buildMinimalTree(A);
        root.printLevel();
        PathsWithSum ps = new PathsWithSum(root, 8);
        System.out.format("%s paths sum to 8\n", ps.getPathsNum());

        System.out.format("---------------\n");
        ps = new PathsWithSum(root, 7);
        System.out.format("%s paths sum to 7\n", ps.getPathsNum());
    }
}