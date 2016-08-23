import java.util.NoSuchElementException;

public class QueueViaStacks
{
    private Stack<Integer> New;
    private Stack<Integer> Old;
    private int            size;

    public
    QueueViaStacks()
    {
        New = new Stack<Integer>();
        Old = new Stack<Integer>();
        size = 0;
    }

    public void enqueue(int value)
    {
        New.push(value);
        size++;
    }

    public int dequeue()
    {
        if (Old.isEmpty())
        {
            if (New.isEmpty())
                throw new NoSuchElementException("stack underflow");
            else
                transfer();
        }
        size--;
        return Old.pop();
    }

    private void transfer()
    {
        while (!New.isEmpty())
        {
            Old.push(New.pop());
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public static void main(String[] args)
    {
        try
        {
            QueueViaStacks qs = new QueueViaStacks();
            for (int i = 0; i < 10; i++)
            {
                qs.enqueue(i);
            }

            while (!qs.isEmpty())
            {
                System.out.format("%d ", qs.dequeue());
            }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}