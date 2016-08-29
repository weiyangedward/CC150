import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;

public class Chopstick
{
    private Lock lock;

    public Chopstick()
    {
        lock = new ReentrantLock();
    }

    public boolean pickUp()
    {
        return lock.tryLock();
    }

    public void putDown()
    {
        lock.unlock();
    }
}