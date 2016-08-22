public class PalindromePermutation
{
    /**
     * count the freq of chars, if a string is palindrome,
     * then it is symmetric at pivot,
     * so there will be <= 1 chars with an odd freq.
     * @param s
     * @return
     */
    public static boolean PalindromePermutation(String s)
    {
        int[] count = new int[256];
        int i;
        for (i=0; i<s.length(); i++)
        {
            count[s.charAt(i)]++;
        }

        int oddChar = 0;
        for (i=0; i<256; i++)
        {
            if (count[i] % 2 != 0)
                oddChar++;
        }

        if (oddChar >= 2) return false;
        return true;
    }

    public static void main(String[] args)
    {
        String s1 = "tactcoa"; // one pivot
        String s2 = "tatcoa"; // two pivots
        String s3 = "tactca"; // no pivot
        System.out.format("is %s palindorme permutation? %b\n", s1, PalindromePermutation(s1));
        System.out.format("is %s palindorme permutation? %b\n", s2, PalindromePermutation(s2));
        System.out.format("is %s palindorme permutation? %b\n", s3, PalindromePermutation(s3));
    }
}