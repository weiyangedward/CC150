public class ReturnKthToLast
{
    public static Node<Integer> ReturnKthToLast(LinkedQueue<Integer> ll, int k)
    {
        Node<Integer> n1 = ll.head();
        Node<Integer> n2 = ll.head();

        for (int i=0; i<k; i++)
            n1 = n1.next;

        while (n1 != null)
        {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2;
    }

    public static void Print(Node<Integer> head)
    {
        Node<Integer> n = head;
        while (n != null)
        {
            System.out.format("%d ", n.item);
            n = n.next;
        }
        System.out.println();
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
        System.out.format("after -------------\n");
        Print(ReturnKthToLast(ll, 3));
    }
}