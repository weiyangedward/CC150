public class EightQueens
{
    private boolean isEightQueue;

    public EightQueens()
    {
        int[][] board = new int[8][8];
        boolean[] rowTaken = new boolean[8];
        eightQueens(board, rowTaken, 0);
        print(board);
    }

    public boolean isEightQueue()
    {
        return isEightQueue;
    }

    public boolean eightQueens(int[][] board, boolean[] rowTaken, int col)
    {
        if (col == 8)
        {
            isEightQueue = true;
            return true;
        }

        for (int row=0; row<8; row++)
        {
            if (valid(board, rowTaken, row, col))
            {
                board[row][col] = col+1;
                rowTaken[row] = true;
                if (eightQueens(board, rowTaken, col+1))
                {
                    return true;
                }
                else
                {
                    board[row][col] = 0;
                    rowTaken[row] = false;
                }
            }
        }
        return false;
    }

    public boolean valid(int[][] board, boolean[] rowTaken, int row, int col)
    {
        // check same spot
        if (board[row][col] > 0) return false;
        // check col
        if (rowTaken[row]) return false;

        // check diagonal
        if (inBound(row-1, col-1) && board[row-1][col-1] > 0) return false;
        if (inBound(row-1, col+1) && board[row-1][col+1] > 0) return false;
        if (inBound(row+1, col-1) && board[row+1][col-1] > 0) return false;
        if (inBound(row+1, col+1) && board[row+1][col+1] > 0) return false;
        return true;
    }

    public boolean inBound(int x, int y)
    {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public void print(int[][] board)
    {
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[0].length; j++)
            {
                System.out.format(",%d", board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        EightQueens eq = new EightQueens();
        System.out.format("is eight queen ? %b\n", eq.isEightQueue());
    }
}