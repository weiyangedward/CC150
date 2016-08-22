import java.util.HashSet;

public class RemoveDups
{
    public static void RemoveDupsUseBuffer(LinkedQueue<Integer> ll)
    {
        if (ll.size() <=0 )return;

        HashSet<Integer> seen = new HashSet<Integer>();
        Node<Integer> cur = ll.head();
        seen.add((Integer)cur.item);

        while(cur.next != null)
        {
            if (seen.contains(cur.next.item))
            {
                cur.next = cur.next.next;
            }
            else
            {
                seen.add((Integer)cur.next.item);
                cur = cur.next;
            }
        }
    }

    public static void RemoveDupsNoBuffer(LinkedQueue<Integer> ll)
    {
        if (ll.size() <=0 )return;

        Node<Integer> cur = ll.head();

        while(cur != null)
        {
            Node<Integer> runner = cur;
            while (runner.next != null)
            {
                if (runner.next.item == cur.item)
                {
                    runner.next = runner.next.next;
                }
                else
                {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedQueue<Integer> ll = new LinkedQueue<Integer>();
        ll.enqueue(1);
        ll.enqueue(2);
        ll.enqueue(3);
        ll.enqueue(1);
        ll.enqueue(3);

        System.out.format("before ------------\n");
        System.out.format("%s\n", ll);
        RemoveDupsUseBuffer(ll);
        System.out.format("after -------------\n");
        System.out.format("%s\n", ll);

        ll = new LinkedQueue<Integer>();
        ll.enqueue(1);
        ll.enqueue(2);
        ll.enqueue(3);
        ll.enqueue(1);
        ll.enqueue(3);

        System.out.format("before ------------\n");
        System.out.format("%s\n", ll);
        RemoveDupsNoBuffer(ll);
        System.out.format("after -------------\n");
        System.out.format("%s\n", ll);
    }
}