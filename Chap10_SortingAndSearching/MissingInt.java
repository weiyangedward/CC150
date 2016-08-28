public class MissingInt
{
    public static int missingInt(int[] A)
    {
        byte[] bitVec = new byte[A[A.length-1]/8 + 1]; // bitVec size depends on the largest num in A

        int i;
        for (i=0; i<A.length; i++)
        {
            bitVec[A[i]/8] |= (byte)(1<<(A[i]%8));
        }

        for (i=0; i<bitVec.length; i++)
        {
            for (int j=0; j<8; j++)
            {
                if ((bitVec[i] & (byte)(1<<j)) == 0)
                {
                    return i*8+j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] A = {0,1,2,3,5,6,8};
        System.out.format("missing int is %d\n", missingInt(A));
    }
}