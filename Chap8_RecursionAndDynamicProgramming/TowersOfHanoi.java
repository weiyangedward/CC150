import java.util.ArrayList;
import java.util.LinkedList;

public class TowersOfHanoi
{
    private LinkedList<Integer> stack;
    private int index;
    private int steps = 0;

    public TowersOfHanoi(int i)
    {
        this.index = i;
        stack = new LinkedList<Integer>();
    }

    public int index()
    {
        return index;
    }

    public int steps()
    {
        return steps;
    }

    public void add(int disk)
    {
        if (!stack.isEmpty() && disk >= stack.peekLast())
            throw new IllegalArgumentException("disk >= top of tower");
        stack.addLast(disk);
    }

    public void moveTopTo(TowersOfHanoi t)
    {
        t.add(stack.pollLast());
        steps++;
    }

    public void moveDisks(int disk, TowersOfHanoi destination, TowersOfHanoi buffer)
    {
        if (disk < 0) return;
        // origin to buffer
        moveDisks(disk-1, buffer, destination);
        // top of origin to destination
        moveTopTo(destination);
        // buffer to destination
        buffer.moveDisks(disk-1, destination, this);
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            ArrayList<TowersOfHanoi> towers = new ArrayList<TowersOfHanoi>();
            int       i;
            for (i = 0; i < 3; i++)
                towers.add(new TowersOfHanoi(i));

            int levels = Integer.parseInt(args[0]);
            for (i=levels-1; i>=0; i--)
                towers.get(0).add(i);

            towers.get(0).moveDisks(levels-1, towers.get(2), towers.get(1));

            int totalSteps = 0;
            for (i=0; i<towers.size(); i++)
                totalSteps += towers.get(i).steps();

            System.out.format("total steps = %d\n", totalSteps);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}