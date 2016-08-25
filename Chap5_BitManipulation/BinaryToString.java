public class BinaryToString
{
    public static String binaryToString(float n)
    {
        if (n < 0 || n >= 1) return "ERROR";

        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (n > 0)
        {
            if (sb.length() > 32) return "ERROR";
            n = 2*n; // shift to the left
            if (n >= 1)
            {
                sb.append("1");
                n -= 1;
            }
            else
            {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        float n = (float)0.72;
        System.out.format("n = %f, binaryString = %s\n", n, binaryToString(n));
        System.out.format("n = %f, binaryString = %s\n", n, Float.to(n))
    }
}