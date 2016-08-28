public class PeaksAndValleys
{
    public static void peaksAndValleys(int[] A)
    {
        for (int i=2; i<A.length; i+=2)
        {
            int left = i-2;
            int mid = i-1;
            int right = i;
            if (A[mid] < A[left] || A[mid] < A[right])
            {
                int swapTo = (A[left] < A[right]) ? right : left;
                swap(A, mid, swapTo);
            }
        }
    }

    public static void swap(int[] A, int i, int j)
    {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void print(int[] A)
    {
        for (int i=0; i<A.length; i++)
            System.out.format("%d ", A[i]);
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] A = {5,3,1,2,3};
        print(A);
        System.out.format("after peaks ---------------\n");
        peaksAndValleys(A);
        print(A);
    }
}