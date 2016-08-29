public class FizzBuzz extends Thread
{
    // static variable, only belongs to class, not objects
    // so can be shared by threads
    private static Object lock = new Object();
    protected static int current = 1; // protected can be accessed by inherited class

    private int max;
    private boolean div3, div5;
    private String toPrint;

    public FizzBuzz(boolean div3, boolean div5, int max, String toPrint)
    {
        this.div3 = div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void print()
    {
        System.out.println(toPrint);
    }

    public void run()
    {
        while (true)
        {
            synchronized (lock)
            {
                if (current > max)
                {
                    return;
                }

                if ( (current % 3 == 0) == div3 && (current % 5 == 0) == div5)
                {
                    print();
                    current++;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int n = 100;
        Thread[] threads =
                {
                    new FizzBuzz(true, true, n, "FizzBuzz"),
                    new FizzBuzz(true, false, n, "Fizz"),
                    new FizzBuzz(false, true, n, "Buzz"),
                    new Number(false, false, n)
                };
        for (Thread thread : threads)
        {
            thread.start();
        }
    }
}