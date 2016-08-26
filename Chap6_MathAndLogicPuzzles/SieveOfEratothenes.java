/**
 * O(n) time to find all primes <= max
 */
public class SieveOfEratothenes
{
    private boolean[] isPrime;
    private boolean[] visited;

    public SieveOfEratothenes(int max)
    {
        isPrime = new boolean[max+1];
        visited = new boolean[max+1];
        for (int i=2; i<=max; i++)
        {
            if (!visited[i])
            {
                isPrime[i] = true;
                crossMutiple(i);
            }
        }
    }

    public void crossMutiple(int n)
    {
        for (int i=n+n; i<isPrime.length; i+=n)
        {
            visited[i] = true;
        }
    }

    public boolean[] getPrimes()
    {
        return isPrime;
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            int max = Integer.parseInt(args[0]);
            SieveOfEratothenes soe = new SieveOfEratothenes(max);
            boolean[] isPrime = soe.getPrimes();
            for (int i=0; i<isPrime.length; i++)
            {
                if (isPrime[i]) System.out.format("%d ", i);
            }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}