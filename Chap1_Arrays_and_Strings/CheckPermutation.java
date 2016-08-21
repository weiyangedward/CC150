public class CheckPermutation
{
    public static boolean CheckPermutation(String s1, String s2)
    {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[256];
        for (int i=0; i<s1.length(); i++)
            count[s1.charAt(i)]++;

        for (int i=0; i<s2.length(); i++)
        {
            count[s2.charAt(i)]--;
            if (count[s2.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String s1 = "dog";
        String s2 = "god";
        String s3 = "hog";
        System.out.format("%s == %s ? %b\n", s1, s2, CheckPermutation(s1, s2));
        System.out.format("%s == %s ? %b\n", s1, s3, CheckPermutation(s1, s3));
    }
}