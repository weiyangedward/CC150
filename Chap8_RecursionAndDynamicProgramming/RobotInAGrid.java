public class RobotInAGrid
{
    public static boolean isPath(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                // value of first col only come from up
                if (j == 0 && i > 0)
                    grid[i][j] = (grid[i][j] > 0) ? grid[i-1][j] : 0;
                // value of first row only come from left
                else if (i == 0 && j > 0)
                    grid[i][j] = (grid[i][j] > 0) ? grid[i][j-1] : 0;
                // ignore grid[0][0], other case come from max(up, left)
                else if (i > 0 && j > 0)
                    grid[i][j] = (grid[i][j] > 0) ? Math.max(grid[i-1][j], grid[i][j-1]) : 0;
            }
        }
        return grid[rows-1][cols-1] > 0;
    }

    public static void main(String[] args)
    {
        int[][] grid =
                {
                        {1,1,0,1,1},
                        {1,1,0,1,1},
                        {1,1,1,1,1}
                };
        System.out.format("is there a path ? %b\n", isPath(grid));
    }
}