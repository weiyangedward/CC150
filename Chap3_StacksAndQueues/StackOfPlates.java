import java.lang.IndexOutOfBoundsException;

public class StackOfPlates
{
    private int threshold;
    private Stack<Stack<Integer>> setOfStacks;
    private int size;

    public StackOfPlates(int threshold)
    {
        this.threshold = threshold;
        this.setOfStacks = new Stack<Stack<Integer>>();
        this.setOfStacks.push(new Stack<Integer>());
        this.size = 0;
    }

    public void push(int value)
    {
        if (setOfStacks.top().size() == threshold)
            setOfStacks.push(new Stack<Integer>());
        setOfStacks.top().push(value);
        size++;
    }

    public int pop(int value)
    {
        if (setOfStacks.top().isEmpty())
            setOfStacks.pop();
        if (setOfStacks.isEmpty()) throw new IllegalArgumentException("stack underflow");
        size--;
        return setOfStacks.top().pop();
    }

    /**
     * pop element at a stack indicated by index
     * @param index
     * @return
     */
    public int popAt(int index)
    {
        int val=-1;
        try
        {
            val = setOfStacks.itemAt(index).pop();
            size--;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return val;
    }

    public int size()
    {
        return size;
    }

    public int totalStacks()
    {
        return setOfStacks.size();
    }


    public static void main(String[] args)
    {
        StackOfPlates sp = new StackOfPlates(10);
        for (int i=0; i<30; i++)
        {
            sp.push(i);
        }
        System.out.format("size = %d, total stacks %d\n", sp.size(), sp.totalStacks());

        for (int i=0; i<3; i++)
        {
            System.out.format("pop at %d = %d\n", i, sp.popAt(i));
        }
        System.out.format("size = %d, total stacks %d\n", sp.size(), sp.totalStacks());
    }
}