public class Partition
{
    public static LinkedQueue<Integer> Partition(LinkedQueue<Integer> ll, int k)
    {
        LinkedQueue<Integer> less = new LinkedQueue<Integer>();
        LinkedQueue<Integer> larger = new LinkedQueue<Integer>();

        Node<Integer> cur = ll.head();
        while (cur != null)
        {
            if (cur.item < k)
            {
                less.addFirst(cur.item);
            }
            else if (cur.item > k)
            {
                larger.addLast(cur.item);
            }
            // cur.item == k
            else
            {
                larger.addFirst(cur.item);
            }
            cur = cur.next;
        }

        less.mergeList(larger);
        return less;
    }

    public static void main(String[] args)
    {
        LinkedQueue<Integer> ll = new LinkedQueue<Integer>();
        ll.enqueue(1);
        ll.enqueue(2);
        ll.enqueue(3);
        ll.enqueue(1);
        ll.enqueue(3);
        ll.enqueue(4);
        ll.enqueue(5);
        ll.enqueue(5);

        System.out.format("before ------------\n");
        System.out.format("%s\n", ll);
        ll = Partition(ll, 3);
        System.out.format("after -------------\n");
        System.out.format("%s\n", ll);
    }
}