public class DrawLine
{
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y)
    {
        if (x2-x1 > width*8) throw new IllegalArgumentException("distance from x1 to x2 is too large");

        int p1 = xyToPos(x1, y, width);
        System.out.format("p1 = %d\n", p1);
        int p2 = xyToPos(x2, y, width);
        System.out.format("p2 = %d\n", p2);
        int index1 = p1 / 8;
        int offset1 = p1 % 8;
        int index2 = p2 / 8;
        int offset2 = p2 % 8;
        System.out.format("index1 = %d, index2 = %d\n", index1, index2);
        System.out.format("offset1 = %d, offset2 = %d\n", offset1, offset2);

        // mask the same byte
        if (index1 == index2)
        {
            byte mask1 = (byte)(0xff >>> offset1);
            byte mask2 = (byte)(0xff << (8-offset2-1));
            screen[index1] |= (mask1&mask2);
        }
        else if (index1 < index2)
        {
            for (int i=index1+1; i<index2; i++)
                screen[i] |= (byte)(0xff);

            byte mask1 = (byte)(0xff >>> offset1);
            byte mask2 = (byte)(0xff << (8-offset2-1));
            screen[index1] |= mask1; // insert 1s from 8-offset1 to the end of index1 byte
            screen[index2] |= mask2; // insert 1s from the start to offset2
        }
    }

    public static int xyToPos(int x, int y, int width)
    {
        int pos = y * width * 8 + x;
        return pos;
    }

    public static String byteString(byte[] screen, int width)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0, j=3; i<screen.length; i+=3, j+=3)
        {
            for (int k=i; k<j; k++)
                sb.append(String.format("%8s,", Integer.toBinaryString(screen[k] & 0xff)).replace(' ','0'));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        byte[] screen = new byte [24]; // 3x8
        System.out.println(byteString(screen, 3));
        drawLine(screen, 3, 3, 22, 2);
        System.out.println(byteString(screen, 3));
    }
}