public class SparseSearch
{
    public static int findStr(String[] list, String target)
    {
        int s = 0, e = list.length-1;

        while (s <= e)
        {
            int mid = s + (e-s)/2;
            if (list[mid].isEmpty())
            {
                int left = mid-1, right = mid+1;
                while (left >= 0 && right <= list.length-1)
                {
                    if (!list[left].isEmpty())
                    {
                        mid = left;
                        break;
                    }
                    if(!list[right].isEmpty())
                    {
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }
                if (list[mid].isEmpty())
                    return -1;
            }

            if (target.compareTo(list[mid]) < 0)
                e = mid-1;
            else if (target.compareTo(list[mid]) < 0)
                s = mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String[] list = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.format("ball has index %d\n", findStr(list, "ball"));
    }
}