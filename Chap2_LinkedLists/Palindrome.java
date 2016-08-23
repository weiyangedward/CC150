public class Palindrome
{
    /**
     * helper class to hold data:
     * Node n
     * boolean isPalindrome
     */
    public static class Result
    {
        Node<Integer> n;
        boolean isPalindrome;

        public Result(Node<Integer> n, boolean isPalindrome)
        {
            this.n = n;
            this.isPalindrome = isPalindrome;
        }
    }

    /**
     * return true if a linked list is a palindrome
     * @param ll
     * @return
     */
    public static boolean Palindrome(LinkedQueue<Integer> ll)
    {
        Node<Integer> n = ll.head();
        for (int i=0; i<ll.size()/2; i++)
            n = n.next;

        Result res = isPalindromeRecursive(ll, n);
        return res.isPalindrome;
    }

    /**
     * recursively check if a linked list is a palindrome
     * @param ll
     * @param n
     * @return
     */
    public static Result isPalindromeRecursive(LinkedQueue<Integer> ll, Node<Integer> n)
    {
        if (n == null)
            return new Result(ll.head(), true);

        Result res = isPalindromeRecursive(ll, n.next);
        if (res.isPalindrome && res.n.item == n.item)
            return new Result(res.n.next, true);
        else
            return new Result(res.n.next, false);
    }

    /**
     * unit test
     * @param args
     */
    public static void main(String[] args)
    {
        LinkedQueue<Integer> ll = new LinkedQueue<Integer>();
        ll.enqueue(0);
        ll.enqueue(1);
        ll.enqueue(2);
        ll.enqueue(3);
        ll.enqueue(2);
        ll.enqueue(1);
        ll.enqueue(0);

        System.out.format("is %s palindrome ? %b\n", ll, Palindrome(ll));

        ll = new LinkedQueue<Integer>();
        ll.enqueue(0);
        ll.enqueue(1);
        ll.enqueue(2);
        ll.enqueue(3);
        ll.enqueue(2);
        ll.enqueue(1);

        System.out.format("is %s palindrome ? %b\n", ll, Palindrome(ll));
    }
}