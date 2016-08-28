import java.util.BitSet;

public class FindDuplicates
{
    public static void findDuplicates(int[] A)
    {
        BitSet bs = new BitSet(8);
        for (int i=0; i<A.length; i++)
        {
            if (bs.get(A[i]))
                System.out.format("dup: %d\n", A[i]);
            else
                bs.set(A[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] A = {0,1,2,2,3,4,4,5};
        findDuplicates(A);
    }
}