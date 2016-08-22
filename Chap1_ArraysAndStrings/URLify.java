public class URLify
{
    /**
     *
     * @param s         char[]
     * @param trueLen   length of a sentence in char[], e.g., "Mr Lee     " has length=6
     * @return
     */
    public static char[] URLify(char[] s, int trueLen)
    {
        int emptySpaceLen = 0, i = 0, index = 0;
        // count empty space before trueLen
        for (i=0; i<trueLen; i++)
        {
            if (s[i] == ' ')
                emptySpaceLen++;
        }

        index = trueLen + emptySpaceLen * 2; // new length of sentence with '%20' inserted
        // copy and insert from end ot front so that it is in-place
        for (i=trueLen-1; i>=0; i--)
        {
            if (s[i] == ' ')
            {
                s[index-1] = '0';
                s[index-2] = '2';
                s[index-3] = '%';
                index -= 3;
            }
            else
            {
                s[index-1] = s[i];
                index -= 1;
            }
        }
        return s;
    }

    public static void main(String[] args)
    {
        String s1 = "Mr John Smith       ";
        char[] s2 = s1.toCharArray();
        System.out.format("original %s, now %s\n", String.valueOf(s2), String.valueOf(URLify(s2, 13)));
    }
}