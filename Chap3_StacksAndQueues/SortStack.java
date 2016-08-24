public class SortStack
{
    public static void SortStack(Stack<Integer> s)
    {
        // a buff stack maintain decreasing sorted order
        Stack<Integer> buff = new Stack<Integer>();
        // move elements from s to buff
        while(!s.isEmpty())
        {
            int tmp = s.pop();
            // compare s.top to buff.top if there is any
            // move buff.top to s if it is > s.top
            while (!buff.isEmpty() && tmp < buff.top())
            {
                s.push(buff.pop());
            }
            buff.push(tmp);
        }

        // push sorted element back to s
        while(!buff.isEmpty())
        {
            s.push(buff.pop());
        }
    }

    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<Integer>();
        int i;
        for (i=9; i>=5; i--)
            s.push(i);
        for (i=0; i<5; i++)
            s.push(i);

        System.out.format("before ----------\n");
        s.Print();

        SortStack(s);
        System.out.format("after ----------\n");
        s.Print();
    }
}