/**
 * 1.1 Is Unique: Implement an algorithm to determine
 * if a string has all unique characters.
 *
 * What if you cannot use additional data structures?
 */

import java.util.Arrays;

public class IsUnique
{
    /**
     * time: O(n)
     * space: extra array
     * @param s
     * @return
     */
    public static boolean IsUniqueExtraSpace(String s)
    {
        // error checking
        int[] count = new int[256];
        for (int i=0 ;i<s.length(); i++)
        {
            int index = s.charAt(i);
            count[index]+=1;
            if (count[index] > 1) return false;
        }
        return true;
    }

    /**
     * time: O(nlogn)
     * space: O(1)
     * @param s
     * @return
     */
    public static boolean IsUniqueConstantSpace(String s)
    {
        // error checking
        char[] copyS = s.toCharArray();
        Arrays.sort(copyS);
        char a, b;
        for (int i=0; i<copyS.length-1; i++)
        {
            a = copyS[i];
            b = copyS[i + 1];
            if (a == b) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String s1 = "dbca";
        String s2 = "dabca";

        System.out.format("IsUniqueExtraSpace ---------\n");
        System.out.format("%s is %b\n", s1, IsUniqueExtraSpace(s1));
        System.out.format("%s is %b\n", s2, IsUniqueExtraSpace(s2));

        System.out.format("IsUniqueConstantSpace ---------\n");
        System.out.format("%s is %b\n", s1, IsUniqueConstantSpace(s1));
        System.out.format("%s is %b\n", s2, IsUniqueConstantSpace(s2));
    }
}