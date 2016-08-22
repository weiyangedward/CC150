public class OneAway
{
    public static boolean OneAway(String first, String second)
    {
        int editDistance = 0;
        int lenDifference = Math.abs(first.length() - second.length());
        if (lenDifference >= 2) return false;

        String s1 = (first.length() < second.length()) ? first : second;
        String s2 = (first.length() < second.length()) ? second : first;

        for (int i1=0, i2=0; i1<s1.length() && i2<s2.length(); i2++)
        {
            // not match
            if (s1.charAt(i1) != s2.charAt(i2))
            {
                editDistance++;
                if (lenDifference == 0) // same len, so is replacement, increase i1
                    i1++;
                // else, is insertion in s2, i1 stays the same
            }
            // matched, increase i1
            else
            {
                i1++;
            }
        }
        return editDistance < 2;
    }

    public static void main(String[] args)
    {
        String a1 = "pale", a2 = "ple";
        System.out.format("a1 %s, a2 %s are one away ? %b\n", a1, a2, OneAway(a1, a2));

        a1 = "pales";
        a2 = "pale";
        System.out.format("a1 %s, a2 %s are one away ? %b\n", a1, a2, OneAway(a1, a2));

        a1 = "pale";
        a2 = "bale";
        System.out.format("a1 %s, a2 %s are one away ? %b\n", a1, a2, OneAway(a1, a2));

        a1 = "pale";
        a2 = "bake";
        System.out.format("a1 %s, a2 %s are one away ? %b\n", a1, a2, OneAway(a1, a2));
    }
}