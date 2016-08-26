/**
 * time O(n) but skip duplicates
 */
public class MagicIndex
{
    public static int magicIndex(int[] A)
    {
        return magicIndex(A, 0, A.length-1);
    }

    public static int magicIndex(int[] A, int s, int e)
    {
        if (e < s) return -1;

        int midIndex = s + (e-s)/2;
        if (A[midIndex] == midIndex) return midIndex;

        // search left
        int leftEnd = Math.min(midIndex-1, A[midIndex]);
        int left =  magicIndex(A, s, leftEnd);
        if (left > 0) return left;

        // search right
        int rightStart = Math.max(midIndex+1, A[midIndex]);
        int right = magicIndex(A,rightStart, e);
        if (right > 0) return right;

        return -1;
    }

    public static void main(String[] args)
    {
        int[] A = {-10, -5, -2, -1, 0, 3, 4, 7, 9, 12, 13};
        System.out.format("magic index is %d\n", magicIndex(A));
    }
}