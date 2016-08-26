public class Apocalypse
{
    public static double boyRatio(int n)
    {
        double sum = 0.0;
        for (int i=1; i<=n; i++)
        {
            double tmp = (double) i / Math.pow(2,i+1);
            sum += tmp;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            int n = Integer.parseInt(args[0]);
            // closed to 1 when n = 10, indicates each family will have in expectation one boy,
            // and must have one girl, so the ratio is even
            System.out.format("ratio of boys is %g, if max baby is %d\n", boyRatio(n), n);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}