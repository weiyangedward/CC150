import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsWithDups
{
    public static
    ArrayList<String> printPerms(String s)
    {
        ArrayList<String> p = new ArrayList<String>();
        HashMap<Character, Integer> charFreq = getCharFreq(s);
        printPerms(p, "", s.length(), charFreq);
        return p;
    }

    public static HashMap<Character, Integer> getCharFreq(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray())
        {
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        return map;
    }

    public static void printPerms(ArrayList<String> p, String prefix, int remain, HashMap<Character, Integer> charFreq)
    {
        if (remain == 0) // prefix length == s.length, add prefix to result
        {
            p.add(prefix);
            return;
        }

        // try and roll-back
        for (Character c : charFreq.keySet())
        {
            int count = charFreq.get(c);
            if (count > 0) // thresholding to cut some path
            {
                charFreq.put(c, count-1); // decrement count
                printPerms(p, prefix + c, remain-1, charFreq); // recursively add char
                charFreq.put(c, count); // roll-back to original count
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            String            s1 = String.valueOf(args[0]);
            ArrayList<String> p  = printPerms(s1);
            for (String s : p)
                System.out.format("%s\n", s);
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }
}