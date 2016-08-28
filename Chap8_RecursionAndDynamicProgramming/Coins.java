import java.util.ArrayList;

public class Coins
{
    public static
    ArrayList<String> getChanges(int total)
    {
        ArrayList<String> res = new ArrayList<String>();
        int[] denoms = {25,10,5,1};
        getChanges(res, "", total, denoms, 0);
        return res;
    }

    public static void getChanges(ArrayList<String> res, String prefix, int total, int[] denoms, int index)
    {
        if (total < 0) return; // denoms overflow

        if (total == 0)
        {
            res.add(prefix);
            return;
        }

        for (int i=0; i<denoms.length; i++)
        {
            // does not allow small denoms to go first,
            // otherwise there will be permutations for the same amount of denoms
            if (i >= index)
                getChanges(res, prefix + "," + String.valueOf(denoms[i]), total - denoms[i], denoms, i);
        }
    }

    public static void main(String[] args)
    {
        int total = 25;
        ArrayList<String> res = getChanges(total);
        System.out.format("%d ways to get changes\n", res.size());
        for (String s : res)
            System.out.format("%s\n", s);
    }
}