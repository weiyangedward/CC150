public class TripleStep
{
    public static int getWaysToUpStaircase(int n)
    {
        if (n <= 3) throw new IllegalArgumentException("n <= 3");
        int[] way = new int[n+1];
        way[1] = 1;
        way[2] = 2;
        way[3] = 4;

        System.out.format("n = %d\n", way.length);
        for (int i=4; i<=n; i++)
        {
            System.out.format("i = %d\n", i);
            way[i] = way[i-1] + way[i-2] + way[i-3];
        }
        return way[n];
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            int n = Integer.parseInt(args[0]);
            System.out.format("with height = %d, there are %d ways to go up\n", n, getWaysToUpStaircase(n));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}