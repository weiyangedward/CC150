public class DeleteMiddleNode
{
    public static void DeleteMiddleNode(Node<Integer> n)
    {
        if (n == null || n.next == null) return;

        int item = (int)n.next.item;
        n.item = item;
        n.next = n.next.next;
    }

    public static void main(String[] args)
    {
        Node<Integer> head = new Node<Integer>(1);
        head.addLast(2);
        head.addLast(3);
        head.addLast(4);
        head.addLast(5);

        Node<Integer> n = head.next.next.next;

        System.out.format("before --------------\n");
        head.Print();
        DeleteMiddleNode(n);
        System.out.format("after --------------\n");
        head.Print();
    }
}