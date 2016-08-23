public class LoopDetection
{
    public static Node<Integer> LoopDetection(Node<Integer> head)
    {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        // find first meet point
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
        }

        // no loop
        if (fast == null || fast.next == null) return null;

        // to meet again at the start of loop
        slow = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args)
    {
        Node<Integer> ll1 = new Node<Integer>(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.addLast(5);
        ll1.next.next.next.next.next = ll1.find(3);

        System.out.format("loop start at %d\n", LoopDetection(ll1).item);
    }
}