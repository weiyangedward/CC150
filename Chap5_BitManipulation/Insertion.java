public class Insertion
{
    public static int insertion(int N, int M, int i, int j)
    {
        // clear bits from i to j in N
        for (int k=i; k<=j; k++)
            N = clearBit(N, k);
        // shift M left i positions, then N | M
        return N | (M<<i);
    }

    public static int clearBit(int N, int i)
    {
        return N & ~(1<<i);
    }

    public static void main(String[] args)
    {
        int N = 2048, M = 19;
        System.out.format("N %s, M %s, M inserted in N %s\n", Integer.toBinaryString(N), Integer.toBinaryString(M), Integer.toBinaryString(insertion(N, M, 2, 6)));
    }
}