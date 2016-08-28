import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams
{
    public static
    ArrayList<String> groupAnagrams(String[] list)
    {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i=0; i<list.length; i++)
        {
            String key = sortChar(list[i].toCharArray());
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(list[i]);
        }

        ArrayList<String> anagrams = new ArrayList<String>();
        for (String key : map.keySet())
        {
            for (String s : map.get(key))
                anagrams.add(s);
        }
        return anagrams;
    }

    public static String sortChar(char[] s)
    {
        Arrays.sort(s);
        return String.valueOf(s);
    }

    public static void main(String[] args)
    {
        String[] list = {"dog", "god", "apple", "pplea", "bear", "areb", "area", "eaar"};
        ArrayList<String> anagrams = groupAnagrams(list);
        for (String s : anagrams)
            System.out.format("%s\n", s);
    }
}