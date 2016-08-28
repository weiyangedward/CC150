import java.util.ArrayList;

public class Parens
{
    public static
    ArrayList<String> getParensPermutations(int pairs)
    {
        ArrayList<String> p = new ArrayList<String>();
        getParensPermutations(p, "", pairs, pairs);
        return p;
    }

    public static void getParensPermutations(ArrayList<String> p, String prefix, int leftRem, int rightRem)
    {
        if (leftRem < 0 || rightRem < 0) return;
        if (leftRem > rightRem) return;
        if (leftRem == 0 && rightRem == 0)
        {
            p.add(prefix);
            return;
        }

        getParensPermutations(p, prefix + "(", leftRem-1, rightRem);
        getParensPermutations(p, prefix + ")", leftRem, rightRem-1);
    }

    public static void main(String[] args)
    {
        int pairs = 3;
        ArrayList<String> p = getParensPermutations(pairs);
        for(String s : p)
            System.out.format("%s\n", s);
    }
}