public class Conversion
{
    public static int bitsToFlip(int n1, int n2)
    {
        int n = (n1 ^ n2);
        int c1 = 0;
        while (n > 0)
        {
            if ((n&1)==1)
                c1++;
            n >>= 1;
        }
        return c1;
    }

    public static void main(String[] args)
    {
        int n1 = 29;
        int n2 = 15;
        System.out.format("n1 %s to n2 %s needs %d flip\n", Integer.toBinaryString(n1), Integer.toBinaryString(n2), bitsToFlip(n1, n2));
    }
}