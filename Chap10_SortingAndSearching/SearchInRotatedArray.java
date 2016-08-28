public class SearchInRotatedArray
{
    public static int searchInRotatedArray(int[] A, int target, int s, int e)
    {
        if (s > e) return -1;

        while (s <= e)
        {
            int mid = s + (e-s)/2;
            System.out.format("s: %d, mid: %d, e: %d\n", s, mid, e);
            if (target < A[mid])
            {
                // if left is sorted
                if (A[s] < A[mid])
                    // if target > s, then target must be at left
                    if (A[s] <= target)
                        return searchInRotatedArray(A, target, s, mid - 1);
                    else
                        return searchInRotatedArray(A, target, mid + 1, e);
                // if right is sorted, then target must be at left
                else if (A[s] > A[mid])
                    return searchInRotatedArray(A, target, s, mid - 1);
                else
                {
                    int result = searchInRotatedArray(A, target, mid + 1, e);
                    if (result == -1)
                        return searchInRotatedArray(A, target, s, mid - 1);
                    else
                        return result;
                }
            }
            else if (A[mid] < target)
            {
                // if right is sorted
                if (A[mid] < A[e])
                {
                    if (target <= A[e])
                        return searchInRotatedArray(A, target, mid + 1, e);
                    else if (target > A[e])
                        return searchInRotatedArray(A, target, s, mid - 1);
                }
                // if left is sorted
                else if (A[mid] > A[e])
                    return searchInRotatedArray(A, target, mid + 1, e);
                // if mid == e, search both side
                else
                {
                    int result = searchInRotatedArray(A, target, mid + 1, e);
                    if (result == -1)
                        return searchInRotatedArray(A, target, s, mid - 1);
                    else
                        return result;
                }
            }
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] A = {14, 15, 16, 19, 20, 24, 25, 5, 7, 10, 12};
        System.out.format("index of 5 is %d\n", searchInRotatedArray(A, 5, 0, A.length-1));

        int[] B = {2, 2, 2, 3, 4, 2};
        System.out.format("index of 4 is %d\n", searchInRotatedArray(B, 4, 0, B.length-1));


    }
}