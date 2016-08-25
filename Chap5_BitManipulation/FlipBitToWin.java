public class FlipBitToWin
{
    public static int longestSeqOfOnes(int n)
    {
        int prevLen=0, curLen=0, max=1;
        while (n > 0)
        {
            if ((n & 1) == 1)
                curLen++;
            else
            {
                // check if next bit is zero
                // here we don't delete the 2nd zero and
                // so will meet it again in the next iteration,
                // but it is ok since the max is recorded,
                // and we are waiting for the next 1 to appear
                prevLen = ((n & 2) == 0) ? 0 : curLen;
                curLen = 0;
            }
            max = Math.max(1 + prevLen + curLen, max);
            n >>>= 1; // logical shift
        }
        return max;
    }

    public static void main(String[] args)
    {
        int n = 1775;
        System.out.format("n %d has longest seq of ones = %d\n", n, longestSeqOfOnes(n));
    }
}