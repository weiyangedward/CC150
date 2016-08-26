public class NextNumber
{
    public static int findNext(int n)
    {
        int c = n; // right-shift c and keep n unchanged
        int c0 = 0; // count 1st right-most 0s
        int c1 = 0; // count 1st right-most 1s

        // count 0s first since error case in findPrev 000..011 has next num 000..101
        while (((c&1) == 0) && c > 0)
        {
            c0++;
            c >>= 1;
        }

        // count 1s
        while ((c&1)==1)
        {
            c1++;
            c >>= 1;
        }

        // ERROR checking
        if ((c0+c1) == 31 || (c0+c1) == 0)
            return -1;

        int p = c0 + c1; // position to insert 1

        n |= (1<<p); // flip 0 to 1
        n &= ~((1<<p)-1); // zero out p-1 to end
        n |= ((1<<(c1-1))-1); // insert (c1-1) 1s to the end
        return n;
    }

    public static int findPrevious(int n)
    {
        int c = n; // right-shift c and keep n unchanged
        int c0 = 0; // count 1st right-most 0s
        int c1 = 0; // count 1st right-most 1s

        // count 1s first since error case in findNext 11..1100 has prev num 11..1010
        while ((c&1)==1)
        {
            c1++;
            c >>= 1;
        }

        // count 0s
        while (((c&1) == 0) && c > 0)
        {
            c0++;
            c >>= 1;
        }

        // ERROR checking
        if ((c0+c1) == 31 || (c0+c1) == 0)
            return -1;

        int p = c0 + c1; // position to insert 1

        n &= ~(1<<p); // flip 1 to 0 at p
        n &= ~((1<<p)-1); // zero out p-1 to end
        n |= (((1<<(c1+1))-1)<<(c0-1)); // insert (c1+1) 0s to the right of p
        return n;
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt("11011001111100", 2);
        System.out.format("%s next larger int is %s\n", Integer.toBinaryString(n), Integer.toBinaryString(findNext(n)));

        n = Integer.parseInt("10011110000011", 2);
        System.out.format("%s next larger int is %s\n", Integer.toBinaryString(n), Integer.toBinaryString(findPrevious(n)));
    }
}