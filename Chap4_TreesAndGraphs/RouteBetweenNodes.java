public class RouteBetweenNodes
{
    private int V;
    private int[] parent;
    private int[] size;

    public RouteBetweenNodes(int V)
    {
        this.V = V;
        this.parent = new int[V];
        this.size = new int[V];
        for (int i=0; i<V; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i)
    {
        valid(i);
        while (i != parent[i])
            i = parent[i];
        return i;
    }

    public void union(int i, int j)
    {
        valid(i);
        valid(j);
        int iRoot = root(i);
        int jRoot = root(j);
        if (iRoot == jRoot) return;
        if (size[iRoot] >= size[jRoot])
        {
            parent[jRoot] = iRoot;
            size[iRoot] += size[jRoot];
        }
        else
        {
            parent[iRoot] = jRoot;
            size[jRoot] += size[iRoot];
        }
    }

    public boolean isConnected(int i, int j)
    {
        valid(i);
        valid(j);
        return root(i) == root(j);
    }

    public void valid(int i)
    {
        if (i < 0 && i >= V) throw new IndexOutOfBoundsException("index " + i);
    }

    public static void main(String[] args)
    {
        try
        {
            RouteBetweenNodes rbn = new RouteBetweenNodes(10);
            for (int i = 0; i < 9; i++)
            {
                System.out.format("is 1 and 6 connected ? %b\n", rbn.isConnected(1, 6));
                System.out.format("union %d and %d\n", i, i + 1);
                rbn.union(i, i + 1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}