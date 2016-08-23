import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

public class Stack<Item>
{
    private Item[] s;
    private int N = 0;

    Stack()
    {
        s = (Item[]) new Object[1]; // use cast
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    /**
     * push a new element at the top
     * @param item
     */
    public void push(Item item)
    {
//        System.out.println("push");
        /*
        * double size of stack if full
        * */
        if (N == s.length) resize(2 * s.length);
        s[N] = item;
        N++;
    }

    /**
     * pop the element at the top
     * @return
     */
    public Item pop()
    {
//        System.out.println("pop");
        if (isEmpty()) throw new NoSuchElementException("Stack Underflow");

        N--;
        Item item = s[N];
        s[N] = null;
        /*
        * halve size of stack if 1/4 full
        * */
        if (N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }

    public Item itemAt(int index)
    {
        if (index < 0 || index >= N) throw new IndexOutOfBoundsException("index out of bound");
        return s[index];
    }

    /**
     * return the top element
     * @return
     */
    public Item top()
    {
        return s[N-1];
    }

    /*
    * resize stack to new capacity and copy items over
    * */
    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i=0;i<N;i++)
            copy[i] = s[i];
        s = copy;
    }

    public void Print()
    {
        for (int i=N-1;i>0;i--)
            System.out.print(s[i]);
        System.out.println();
    }

}