public class SortedSearchNoSize
{
    public static
    int indexOf(int[] A, int target)
    {
        int k    = getEnd(A);
        int sEnd = (int)Math.pow((double)2, (double)(k - 1));
        int eEnd = (int)Math.pow((double)2, (double)k);
        int i;
        for (i = sEnd; i < eEnd; i++)
        {
            if (elementAt(A, i) == -1)
                break;
        }
        int length = i;

        return binarySearch(A, 0, length - 1, target);
    }

    public static
    int elementAt(int[] A, int i)
    {
        if (i < 0 || i >= A.length)
            return -1;
        else
            return A[i];
    }


    public static
    int binarySearch(int[] A, int s, int e, int target)
    {
        if (s > e) return -1;

        while (s <= e)
        {
            int mid = s + (e - s) / 2;
            if (elementAt(A, mid) < target)
                s = mid + 1;
            else if (target < elementAt(A, mid))
                e = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static
    int getEnd(int[] A)
    {
        int k   = 0;
        int val = elementAt(A, k);
        while (val > 0)
        {
            k++;
            val = elementAt(A, (int)Math.pow((double)2, (double)k));
        }
        return k;
    }

    public static void main(String[] args)
    {
        int[] A = {1,3,5,7,9,11,13,15,17};
        System.out.format("7 is at index %d\n", indexOf(A, 7));
    }

}
