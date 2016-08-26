import java.util.ArrayList;

public class PowerSet
{
    public static ArrayList<ArrayList<Integer>> getPowerSet(int[] A)
    {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
        powerSet.add(new ArrayList<Integer>());
        for (int i=0; i<A.length; i++)
        {
            ArrayList<ArrayList<Integer>> tmpSet = new ArrayList<ArrayList<Integer>>();
            for (int s=0; s<powerSet.size(); s++)
            {
                ArrayList<Integer> tmp = new ArrayList<Integer>(powerSet.get(s));
                tmp.add(A[i]);
                tmpSet.add(tmp);
            }
            powerSet.addAll(tmpSet);
        }
        return powerSet;
    }

    private static void printSets(ArrayList<ArrayList<Integer>> sets)
    {
        for (ArrayList<Integer> s : sets)
        {
            if (s.size() == 0)
                System.out.format("{}");
            for (Integer i : s)
            {
                System.out.format("%d ", i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        try
        {
            int[]                         A        = {1, 2, 3};
            ArrayList<ArrayList<Integer>> powerSet = getPowerSet(A);
            printSets(powerSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}