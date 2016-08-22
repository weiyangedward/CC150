public class RotateMatrix
{
    public static void RotateMatrix(int[][] m)
    {
        int n = m.length;
        int is, ie;
        int[] buff;
        int i, len;
        // there are n/2 rings
        for (int ring=0; ring<n/2; ring++)
        {
            is = ring;
            ie = n - 1 - ring;
            len = ie - is; // distance between is and ie

            // copy left to buffer
            buff = new int[len];
            for (i=0; i<len; i++)
                buff[i] = m[i+is][is];

            // rotate four edges of the ring,
            // one position at a time,
            // each edge has len-1 positions
            for (i=0; i<len; i++)
            {
                // left <- bottom
                m[i+is][is] = m[ie][is+i];

                // bottom <- right
                m[ie][i+is] = m[ie-i][ie];

                // right <- up
                m[ie-i][ie] = m[is][ie-i];

                // up <- left
                m[is][ie-i] = buff[i];
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
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16},
                };
        System.out.format("before ------\n");
        Print(m1);

        RotateMatrix(m1);
        System.out.format("after ------\n");
        Print(m1);

        int[][] m2 =
                {
                        {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}
                };
        System.out.format("before ------\n");
        Print(m2);

        RotateMatrix(m2);
        System.out.format("after ------\n");
        Print(m2);
    }
}