public class Intersection
{
    public static Node<Integer> Intersection(Node<Integer> head1, Node<Integer> head2)
    {
        // tails are different if no intersection
        if (!isIntersect(head1, head2)) return null;

        // walk the head of longer ll forward
        int size1 = size(head1);
        int size2 = size(head2);
        if (size1 > size2)
            head1 = walkForward(head1, size1-size2);
        else
            head2 = walkForward(head2, size2-size1);

        // find and return intersection
        while (head1 != null && head2 != null)
        {
            System.out.format("head1: %d, head2: %d\n", head1.item, head2.item);
            if (head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    /**
     * return the size of a list
     * @param head1
     * @return
     */
    private static int size(Node<Integer> head1)
    {
        Node<Integer> n = head1;
        int size = 0;
        while (n != null)
        {
            n = n.next;
            size++;
        }
        return size;
    }

    /**
     * return true if two lists are intersected
     * @param head1
     * @param head2
     * @return
     */
    private static boolean isIntersect(Node<Integer> head1, Node<Integer> head2)
    {
        Node<Integer> tail1 = head1;
        while (tail1.next != null)
            tail1 = tail1.next;

        Node<Integer> tail2 = head2;
        while (tail2.next != null)
            tail2 = tail2.next;

        return tail1 == tail2;
    }

    /**
     * walk the head of the longer list forward
     * @param n
     * @param steps
     * @return
     */
    private static Node<Integer> walkForward(Node<Integer> n, int steps)
    {
        for (int i=0; i<steps; i++)
            n = n.next;
        return n;
    }

    /**
     * unit test
     * @param args
     */
    public static void main(String[] args)
    {
        Node<Integer> ll1 = new Node<Integer>(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.addLast(5);

        Node<Integer> ll2 = new Node<Integer>(1);
        ll2.addLast(2);
        ll2.next.next = ll1.find(4);

        ll1.Print();
        ll2.Print();
        System.out.format("intersect: %d\n", Intersection(ll1, ll2).item);
    }
}