import java.util.Arrays;

public class StringRotation
{
    /**
     * return true is s2 is a rotation of s1 at a rotation point
     * try all possible rotation points in s2
     * @param s1
     * @param s2
     * @return
     */
    public static boolean StringRotation(String s1, String s2)
    {
        if (s1.length() <= 0 && s1.length() != s2.length()) return false;

        int s = 0, e = s2.length(); // substring is from s to e-1
        for (int i=0; i<=s2.length(); i++)
        {
            String first = s2.substring(0, i);
            String second = s2.substring(i,e);
            System.out.format("first: %s, second: %s\n", first, second);
            if (isSubstring(s1, second + first)) return true;
        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2)
    {
        return s1.contains(s2);
    }

    public static void main(String[] args)
    {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.format("is %s a substring of %s ? %b\n", s1, s2, StringRotation(s1, s2));
    }
}