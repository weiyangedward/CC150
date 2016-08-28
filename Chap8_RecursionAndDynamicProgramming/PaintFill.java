public class PaintFill
{
    public static void paintFill(int[][] screen, int x, int y, int originalCol, int newCol)
    {
        if (x < 0 || x > screen[0].length || y < 0 || y > screen.length) return;

        if (screen[x][y] == originalCol)
        {
            screen[x][y] = newCol;
            paintFill(screen, x-1, y, originalCol, newCol);
            paintFill(screen, x+1, y, originalCol, newCol);
            paintFill(screen, x, y-1, originalCol, newCol);
            paintFill(screen, x, y+1, originalCol, newCol);
        }
    }

    public static void print(int[][] s)
    {
        for (int i=0; i<s.length; i++)
        {
            for (int j=0; j<s[0].length; j++)
                System.out.format("%d ", s[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] screen =
                {
                        {1,1,1,1,1},
                        {1,1,2,1,1},
                        {1,2,2,2,1},
                        {1,1,2,2,1},
                        {1,1,1,1,1},
                };
        System.out.format("before -----------\n");
        print(screen);

        System.out.format("after ------------\n");
        paintFill(screen, 2, 2, 2, 3);
        print(screen);
    }
}