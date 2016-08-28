public class SortedMatrixSearch
{
    public static String searchMatrix(int[][] M, int target)
    {
        int rows = M.length;
        int cols = M[0].length;
        int i = 0, j = cols-1;
        while (valid(i,rows) && valid(j, cols))
        {
            if (target < M[i][j])
                j -= 1;
            else if (M[i][j] < target)
                i += 1;
            else
                return String.valueOf(i) + "," + String.valueOf(j);
        }
        return "-1,-1";
    }

    public static boolean valid(int i, int length)
    {
        return i >= 0 && i < length;
    }

    public static void main(String[] args)
    {
        int[][] M =
                {
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                };
        int n = 10;
        System.out.format("%d is at index %s\n", n, searchMatrix(M, n));
    }
}