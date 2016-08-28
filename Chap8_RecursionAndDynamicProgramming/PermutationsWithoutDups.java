import java.util.ArrayList;

public class PermutationsWithoutDups
{
    public static ArrayList<StringBuilder> getPermutations(String s)
    {
        ArrayList<StringBuilder> p = new ArrayList<StringBuilder>();
        p.add(new StringBuilder(String.valueOf(s.charAt(0))));
        for (int i=1; i<s.length(); i++)
            p = insert(p, s.charAt(i));
        return p;
    }

    /**
     * insert new char to every position of a string in permutation list
     * return return the new list
     * @param p
     * @param c
     * @return
     */
    public static ArrayList<StringBuilder> insert(ArrayList<StringBuilder> p, char c)
    {
        ArrayList<StringBuilder> tmp = new ArrayList<StringBuilder>();
        for (int i=0; i<p.size(); i++)
        {
            for (int j=0; j<=p.get(i).length(); j++)
            {
                StringBuilder copy = new StringBuilder(p.get(i));
                tmp.add(copy.insert(j,c));
            }
        }
        return tmp;
    }

    public static void print(ArrayList<StringBuilder> p)
    {
        for (int i=0; i<p.size(); i++)
            System.out.format("%s\n", p.get(i));
    }

    public static void main(String[] args)
    {
        String str = "aabc";
        ArrayList<StringBuilder> p = getPermutations(str);
        print(p);
    }
}