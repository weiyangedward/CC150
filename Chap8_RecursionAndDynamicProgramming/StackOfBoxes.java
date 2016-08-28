import java.util.ArrayList;

    public class StackOfBoxes
    {
        private int maxHeight = 0;

        public static class Box
        {
            public int height;
            public int width;
            public int depth;

            public Box(int h, int w, int d)
            {
                height = h;
                width = w;
                depth = d;
            }

            public int compareTo(Box that)
            {
                if (this.height < that.height && this.width < that.width && this.depth < that.depth)
                    return -1;
                else if (this.height == that.height && this.width == that.width && this.depth == that.depth)
                    return 0;
                else
                    return 1;
            }
        }

        public StackOfBoxes(ArrayList<Box> boxList)
        {
            int[] height = new int[boxList.size()];
            for (int i=0; i<boxList.size(); i++)
            {
                int max = boxList.get(i).height;
                for (int j=i; j>=0; j--)
                {
                    if (boxList.get(i).compareTo(boxList.get(j)) < 0 && (height[j] + boxList.get(i).height > max))
                        max = height[j] + boxList.get(i).height;
                }
                height[i] = max;
                if (max > maxHeight)
                    maxHeight = max;
            }
        }

        public int getMaxHeight()
        {
            return maxHeight;
        }

    public static void main(String[] args)
    {
        ArrayList<Box> boxList = new ArrayList<StackOfBoxes.Box>();
        boxList.add(new Box(10,9,8));
        boxList.add(new Box(1,2,3));
        boxList.add(new Box(9,8,7));
        boxList.add(new Box(8,7,6));
        boxList.add(new Box(11,10,9));
        boxList.add(new Box(2,3,4));

        StackOfBoxes sb = new StackOfBoxes(boxList);
        System.out.format("max height of box is %d\n", sb.getMaxHeight());
    }
}