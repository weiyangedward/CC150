import java.lang.StringBuilder;

public class StringCompression
{
    public static String StringCompression(String s)
    {
        StringBuilder sb = new StringBuilder();
        char a = s.charAt(0), b;
        int count = 1, i;
        for (i=1; i<s.length(); i++)
        {
            b = s.charAt(i);
            if (a == b)
            {
                count++;
                if (i == s.length()-1) // edge case when string ends
                    sb.append(String.valueOf(a) + String.valueOf(count));
            }
            else
            {
                sb.append(String.valueOf(a) + String.valueOf(count));
                a = b;
                count = 1;
            }
        }

        return (sb.length() > s.length()) ? s : sb.toString();
    }

    public static void main(String[] args)
    {
        String s1 = "aabcccccaaa"; // return compressed string
        System.out.format("before: %s, after: %s\n", s1, StringCompression(s1));

        s1 = "abcd"; // return original string
        System.out.format("before: %s, after: %s\n", s1, StringCompression(s1));
    }
}