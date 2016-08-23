public class StackMin
{
    private int N;
    private Object[] S;
    private int top;

    public class Element
    {
        public int value;
        public int min;

        Element(int value, int min)
        {
            this.value = value;
            this.min = min;
        }
    }

    public StackMin(int N)
    {
        this.N = N;
        S = new Object[N];
        top = 0;
    }

    public void push(int value) throws IllegalArgumentException
    {
        if (top == N) throw new IllegalArgumentException("stack overflow");

        if (top == 0)
            S[top] = new Element(value, value);
        else
            S[top] = new Element(value, Math.min(value, ((Element)S[top-1]).min));
        top++;
    }

    public int pop() throws IllegalArgumentException
    {
        if (top == 0) throw new IllegalArgumentException("stack underflow");

        int val = ((Element)S[--top]).value;
        return val;
    }

    public int size()
    {
        return top;
    }

    public int min() throws IllegalArgumentException
    {
        if (top == 0) throw new IllegalArgumentException("stack underflow");
        return ((Element)S[top-1]).min;
    }

    public void Print()
    {
        for (int i=top-1; i>=0; i--)
            System.out.format("%d ", ((Element)S[i]).value);
        System.out.println();
    }

    public static void main(String[] args)
    {
        StackMin sm = new StackMin(10);

        for (int i=0; i<10; i++)
        {
            sm.push(10-i);
        }

        while (sm.size() > 0)
        {
            sm.Print();
            System.out.format("min: %d\n", sm.min());
            sm.pop();
        }
    }
}