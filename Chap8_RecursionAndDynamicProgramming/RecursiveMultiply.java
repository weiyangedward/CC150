public class RecursiveMultiply
{
    public static int multiple(int x, int y)
    {
        int n1 = (x < y) ? x : y;
        int n2 = (x < y) ? y : x;

        int prev = n2;
        for (int i=0; i<n1/2; i++)
        {
            n2 += n2;
        }

        if (n1 % 2 > 0)
            n2 += prev;
        return (n1 > 0) ? n2 : 0;
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.format("%d x %d = %d\n", x, y, multiple(x, y));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}