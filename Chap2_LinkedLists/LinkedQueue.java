import java.util.NoSuchElementException;
import java.util.*;

/**
 * represents a first-in-first-out (FIFO) queue of generic items.
 * This implementation uses a singly-linked list with a non-static nested class
 * for linked-list nodes.
 */
class LinkedQueue<Item> implements Iterable<Item>
{
    private int  N;
    private Node<Item> first;
    private Node<Item> last;

    /**
     * constructor
     */
    public
    LinkedQueue()
    {
        first = null;
        last = null;
        N = 0;
    }

    /**
     * add a new item to the back of queue
     * @param item
     */
    public
    void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) { first = last; }
        else { oldLast.next = last; }
        N++;
    }

    /**
     * add a new item to the back of queue
     * @param item
     */
    public void addLast(Item item)
    {
        enqueue(item);
    }

    /**
     * add a new item to the head of queue
     * @param item
     */
    public void addFirst(Item item)
    {
        if (isEmpty())
        {
            first = new Node(item);
            last = first;
        }
        else
        {
            Node newHead = new Node(item, first);
            first = newHead;
        }
        N++;
    }

    /**
     * remove the first item from the queue
     * @return
     */
    public
    Item dequeue()
    {
        if (isEmpty()) { throw new NoSuchElementException("Queue underflow"); }
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) { last = null; }
        return item;
    }

    /**
     * remove a node given a key
     * @param key
     */
    public void remove(Item key)
    {
        if (isEmpty()) { throw new NoSuchElementException("Queue underflow"); }
        Node<Item> prev = first;
        Node<Item> cur = first.next;
        while (cur != null)
        {
            if (cur.item == key)
            {
                prev.next = cur.next;
                N--;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public
    String toString()
    {
        StringBuilder s   = new StringBuilder();
        Node          tmp = first;
        while (tmp != null)
        {
            s.append(tmp.item + " ");
            tmp = tmp.next;
        }
        return s.toString();
    }

    /**
     * return iterator of items in queue
     * @return
     */
    public
    Iterator<Item> iterator()
    {
        return new QueueIterator();
    }

    private
    class QueueIterator implements Iterator<Item>
    {
        private Node<Item> current = first;

        public
        boolean hasNext()
        {
            return current != null;
        }

        public
        void remove()
        {
            throw new UnsupportedOperationException();
        }

        public
        Item next()
        {
            if (!hasNext()) { throw new NoSuchElementException(); }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * utility functions
     */
    public
    boolean isEmpty()
    {
        return N == 0;
    }

    public
    int size()
    {
        return N;
    }

    public
    Item peek()
    {
        if (isEmpty()) { throw new NoSuchElementException("Queue underflow"); }
        return first.item;
    }

    public Node head()
    {
        return first;
    }

    public Node tail()
    {
        return last;
    }

    public void mergeList(LinkedQueue<Item> ll)
    {
        this.last.next = ll.head();
        this.last = ll.tail();
        this.N += ll.size();
    }

    /**
     * unit test
     * @param args
     */
    public static
    void main(String[] args)
    {
        LinkedQueue<String> q  = new LinkedQueue<String>();
        Scanner             sc = new Scanner(System.in);
        sc.useDelimiter("\\s+");
        while (sc.hasNextLine())
        {
            String s = sc.nextLine();
            s = s.trim(); // get rid of newline

            if (!s.equals("-"))
            {
                q.enqueue(s);
            }
            else
            {
                System.out.format("%s ", q.dequeue());
            }
        }
        System.out.println();
    }
}