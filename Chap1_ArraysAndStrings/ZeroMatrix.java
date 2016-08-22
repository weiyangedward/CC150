public class ZeroMatrix
{
    public static void ZeroMatrix(int[][] m)
    {
        int row = m.length, col = m[0].length;
        int i, j;
        boolean[] rowTo0 = new boolean[row]; // rows to be zero
        boolean[] colTo0 = new boolean[col]; // cols to be zero

        // record rows and cols to be zero
        for (i=0; i<row; i++)
        {
            for (j=0; j<col; j++)
            {
                if (m[i][j] == 0)
                {
                    rowTo0[i] = true;
                    colTo0[j] = true;
                }
            }
        }
        // zero out rows and cols recorded
        for (i=0; i<row; i++)
        {
            for (j=0; j<col; j++)
            {
                if (rowTo0[i] || colTo0[j])
                {
                    m[i][j] = 0;
                }
            }
        }
    }

    public static void Print(int[][] m)
    {
        for (int i=0; i<m.length; i++)
        {
            for (int j=0; j<m[0].length; j++)
            {
                System.out.format("%d, ", m[i][j]);
            }
            System.out.format("\n");
        }
    }

    public static void main(String[] args)
    {
        int[][] m1 =
                {
                        {1,2,3,0},
                        {5,0,7,8},
                        {9,10,11,0},
                        {13,14,15,16},
                        };
        System.out.format("before --------------\n");
        Print(m1);
        ZeroMatrix(m1);
        System.out.format("after ---------------\n");
        Print(m1);

        int[][] m2 =
                {
                        {0,2,3,4,5},
                        {6,0,8,9,10},
                        {11,12,0,14,15},
                        {16,17,18,0,20},
                        {21,22,23,24,25}
                };
        System.out.format("before --------------\n");
        Print(m2);
        ZeroMatrix(m2);
        System.out.format("after ---------------\n");
        Print(m2);
    }
}