public class SortedMerge
{
    public static void sortedMerge(int[] A, int[] B, int lenA)
    {
        if ((A.length - lenA) < B.length) throw new IllegalArgumentException("A is too short");

        int ptrA = lenA-1;
        int ptrB = B.length-1;
        int ptrBuff = A.length-1;

        while (ptrBuff >= 0)
        {
            // B is done
            if (ptrA >= 0 && ptrB < 0)
            {
                A[ptrBuff] = A[ptrA];
                ptrA--;
            }
            // A is done
            else if (ptrA < 0 && ptrB >= 0)
            {
                A[ptrBuff] = B[ptrB];
                ptrB--;
            }
            // A > B
            else if (A[ptrA] >= B[ptrB])
            {
                A[ptrBuff] = A[ptrA];
                ptrA--;
            }
            // B > A
            else if (A[ptrA] < B[ptrB])
            {
                A[ptrBuff] = B[ptrB];
                ptrB--;
            }
            ptrBuff--;
        }
    }

    public static void main(String[] args)
    {
        int[] A = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 5;

        int[] B = {2,4,6,8,10};
        sortedMerge(A, B, 3);
        for (int i=0; i<A.length; i++)
            System.out.format("%d ", A[i]);
        System.out.println();
    }
}