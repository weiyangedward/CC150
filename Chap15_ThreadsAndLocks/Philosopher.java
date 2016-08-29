import java.util.ArrayList;

public class Philosopher extends Thread
{
    private int bites = 10;
    private int id;
    private Chopstick left, right;

    public Philosopher(int id, Chopstick left, Chopstick right)
    {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public void eat()
    {
        if (pickUp())
        {
            bites--;
            chew();
            putDown();
        }
        try
        {
            Thread.sleep(100);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * all-or-nothing to prevent deadlock
     * @return
     */
    public boolean pickUp()
    {
        if (!left.pickUp()) return false;
        System.out.format("%d pick up left\n", id);

        if (!right.pickUp())
        {
            left.putDown();
            return false;
        }
        System.out.format("%d pick up right\n", id);
        return true;
    }

    public void chew()
    {
        System.out.format("%d chew\n", id);
        try
        {
            Thread.sleep(100);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void putDown()
    {
        right.putDown();
        left.putDown();
    }

    public void run()
    {
        while (bites > 0)
        {
            eat();
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Chopstick> ct = new ArrayList<Chopstick>();
        for (int i=0; i<2; i++)
            ct.add(new Chopstick());

        ArrayList<Philosopher> phi = new ArrayList<Philosopher>();
        for (int i=1; i<=1; i++)
            phi.add(new Philosopher(i, ct.get(i-1), ct.get(i)));

        phi.add(new Philosopher(2, ct.get(1), ct.get(0)));

        for (Philosopher p : phi)
            p.start();
    }
}
