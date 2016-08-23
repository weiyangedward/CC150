import java.util.Arrays;
import java.lang.IllegalArgumentException;

public class ThreeInOne
{
    private int N;
    private int totalStacks;
    private Object[] A;
    private int[] size;
    private int[] top;
    private int totalTop;
    private int totalSize;

    public class Element extends Object
    {
        int value;
        int next;

        public Element(int value)
        {
            this.value = value;
            next = -1;
        }
    }

    public ThreeInOne(int N, int totalStacks)
    {
        this.N = N;
        this.totalStacks = totalStacks;
        this.A = new Object[N];
        this.size = new int[totalStacks];
        this.top = new int[totalStacks];
        this.totalTop = 0;
        this.totalSize = 0;
    }

    public void push(int stackNum, int value) throws IllegalArgumentException
    {
        if (totalSize == N) throw new IllegalArgumentException("stack overflow");

        A[totalTop] = new Element(value);
        if (size[stackNum] > 0)
            ((Element)A[totalTop]).next = top[stackNum];
        top[stackNum] = totalTop;
        totalTop = findTop();
        totalSize++;
        size[stackNum]++;
    }

    public int pop(int stackNum) throws IllegalArgumentException
    {
        if (size[stackNum] == 0) throw new IllegalArgumentException("stack underflow");

        Element ans = (Element) A[top[stackNum]];
        int next = ans.next;
        int val = ans.value;
        A[top[stackNum]] = null;
        top[stackNum] = next;
        totalTop = findTop();
        size[stackNum]--;
        totalSize--;
        return val;
    }

    private int findTop()
    {
        int[] candTop = new int[totalStacks];
        int i;
        for (i=0; i<totalStacks; i++)
            candTop[i] = (top[i]+1)%N;

        Arrays.sort(candTop);
        for (i=0; i<totalStacks; i++)
        {
            if (A[candTop[i]] == null)
                return candTop[i];
        }
        return -1;
    }

    public void Print(int stackNum)
    {
        System.out.format("printing stack %d\n", stackNum);
        int index = top[stackNum];
        while (index != -1)
        {
            System.out.format("%d ", ((Element)A[index]).value);
            index = ((Element)A[index]).next;
        }
        System.out.println();
    }

    public int size()
    {
        return totalSize;
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            ThreeInOne tio = new ThreeInOne(30, 3);
            for (int i = 0; i < 5; i++)
                tio.push(0, i);

            for (int i = 5; i < 15; i++)
                tio.push(1, i);

            for (int i = 15; i < 30; i++)
                tio.push(2, i);

            System.out.format("before pop ----------------\n");
            System.out.format("size = %d\n", tio.size());
            tio.Print(0);
            tio.Print(1);
            tio.Print(2);

            System.out.format("after pop -----------------\n");
            tio.pop(0);
            tio.pop(1);
            tio.pop(2);
            System.out.format("size = %d\n", tio.size());
            tio.Print(0);
            tio.Print(1);
            tio.Print(2);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}