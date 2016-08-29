import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public
class CallInOrder
{
    private static Semaphore sem1 = new Semaphore(1);
    private static Semaphore sem2 = new Semaphore(1);

    public
    CallInOrder()
    {
        try
        {
            sem1.acquire();
            sem2.acquire();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public
    void run()
    {
        System.out.format("running\n");
    }

    public static
    boolean first()
    {
        try
        {
            // this has to go before release, otherwise the print order is incorrect
            // since second() might be called before print
            System.out.format("first\n");
            sem1.release();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static
    boolean second()
    {
        try
        {
            sem1.acquire(); // only after first()
            sem2.release();
            System.out.format("second\n");
            sem1.release();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static
    boolean third()
    {
        try
        {
            sem2.acquire();
            sem2.release();
            sem1.acquire();
            sem1.release();
            System.out.format("third\n");
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static
    void main(String[] args)
    {
        CallInOrder cio = new CallInOrder();

        Thread thread1 = new Thread()
        {

            public
            void run()
            {
                boolean done = false;
                while (!done)
                {
                    done = first();
                }
            }
        };

        Thread thread2 = new Thread()
        {

            public
            void run()
            {
                boolean done = false;
                while (!done)
                {
                    done = second();
                }
            }
        };

        Thread thread3 = new Thread()
        {

            public
            void run()
            {
                boolean done = false;
                while (!done)
                {
                    done = third();
                }
            }
        };

        thread3.start();
        thread2.start();
        thread1.start();
    }
}