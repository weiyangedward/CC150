public class PairwiseSwap
{
    public static int swapOddAndEven(int n)
    {
        int odd = 0xaaaaaaaa;
        int even = odd >>> 1;
        int oddN = n & odd;
        oddN >>>= 1;
        int evenN = n & even;
        evenN <<= 1;
        return oddN | evenN;
    }

    public static void main(String[] args)
    {
        int n = 0xaaaaaaaa;
        System.out.format("before: %s\n", Integer.toBinaryString(n));
        System.out.format("after: %s\n", Integer.toBinaryString(swapOddAndEven(n)));
    }
}