public class SumLists
{
    /**
     * sum linked list representation of nums in reverse order
     * @param num1
     * @param num2
     * @return
     */
    public static LinkedQueue<Integer> SumListsReverse(LinkedQueue<Integer> num1, LinkedQueue<Integer> num2)
    {
        LinkedQueue<Integer> sumNum = new LinkedQueue<Integer>();
        Node<Integer> n1 = num1.head();
        Node<Integer> n2 = num2.head();
        int toAdd = 0;
        while (n1 != null || n2 != null)
        {
            int d1 = 0, d2 = 0;
            if (n1 != null)
            {
                d1 = n1.item;
                n1 = n1.next;
            }
            if (n2 != null)
            {
                d2 = n2.item;
                n2 = n2.next;
            }
            int sum = toAdd + d1 + d2;
            if (sum >= 10)
            {
                toAdd = 1;
                sum -= 10;
            }
            sumNum.addLast(sum);
        }
        return sumNum;
    }

    /**
     * sum linked list representation of nums in forward order
     * @param num1
     * @param num2
     * @return
     */
    public static LinkedQueue<Integer> SumListsForward(LinkedQueue<Integer> num1, LinkedQueue<Integer> num2)
    {
        LinkedQueue<Integer> sumNum = new LinkedQueue<Integer>();
        boolean toPadZero = (num1.size() > num2.size()) ? padZero(num2, num1.size()-num2.size()) : padZero(num1, num2.size()-num1.size());
        addListHelper(sumNum, num1.head(), num2.head());
        return sumNum;
    }

    /**
     * recursively to sum two numbers
     * @param sumNum
     * @param n1
     * @param n2
     * @return
     */
    private static int addListHelper(LinkedQueue<Integer> sumNum, Node<Integer> n1, Node<Integer> n2)
    {
        if (n1 == null && n2 == null)
            return 0;

        int sumCarry = addListHelper(sumNum, n1.next, n2.next);
        int sumVal = sumCarry + n1.item + n2.item;
        if (sumVal >= 10)
        {
            sumCarry = 1;
            sumVal -= 10;
        }
        sumNum.addFirst(sumVal);
        return sumCarry;
    }

    /**
     * pad zeros in front of a number when it is shorter than another
     * @param num
     * @param zeroToAdd
     * @return
     */
    private static boolean padZero(LinkedQueue<Integer> num, int zeroToAdd)
    {
        for (int i=0; i<zeroToAdd; i++)
            num.addFirst(0);
        return true;
    }

    /**
     * unit test
     * @param args
     */
    public static void main(String[] args)
    {
        LinkedQueue<Integer> num1 = new LinkedQueue<Integer>();
        num1.enqueue(7);
        num1.enqueue(1);
        num1.enqueue(6);

        LinkedQueue<Integer> num2 = new LinkedQueue<Integer>();
        num2.enqueue(5);
        num2.enqueue(9);
        num2.enqueue(2);

        System.out.format("before ------------\n");
        System.out.format("num1 %s, num2 %s\n", num1, num2);
        LinkedQueue<Integer> sum = SumListsReverse(num1, num2);
        System.out.format("after -------------\n");
        System.out.format("sum %s\n", sum);

        num1 = new LinkedQueue<Integer>();
        num1.enqueue(6);
        num1.enqueue(1);
        num1.enqueue(7);

        num2 = new LinkedQueue<Integer>();
        num2.enqueue(2);
        num2.enqueue(9);
        num2.enqueue(5);

        System.out.format("before ------------\n");
        System.out.format("num1 %s, num2 %s\n", num1, num2);
        sum = SumListsForward(num1, num2);
        System.out.format("after -------------\n");
        System.out.format("sum %s\n", sum);
    }
}