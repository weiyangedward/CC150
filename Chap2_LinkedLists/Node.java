public
class Node<Item>
{
    public Item item;
    public Node next;

    public Node(Item item, Node next)
    {
        this.item = item;
        this.next = next;
    }

    public Node(Item item)
    {
        this(item, null);
    }

    public Node()
    {
        this(null, null);
    }

    public void addLast(Item item)
    {
        Node n = this;
        while (n.next != null)
            n = n.next;
        n.next = new Node(item);
    }

    public void Print()
    {
        Node n = this;
        while (n != null)
        {
            System.out.format("%s ", n.item);
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Node head = new Node<Integer>(1);
        head.addLast(2);
        head.Print();
    }
}
