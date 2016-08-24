import java.util.ArrayList;

public class BuildOrder
{
    private static ArrayList<Integer> reverseStack;
    private static boolean[] visited;
    private static Digraph copyG;

    public static ArrayList<Integer> buildOrder(Digraph G)
    {
        reverseStack = new ArrayList<Integer>();
        visited = new boolean[G.V()];
        copyG = G;
        for (int v=0; v<G.V(); v++)
        {
            if (!visited[v]) postOrderDFS(v);
        }
        return reverseStack;
    }

    public static void postOrderDFS(int v)
    {
        visited[v] = true;
        for (int w : copyG.adj(v))
        {
            if (!visited[w]) postOrderDFS(w);
        }
        reverseStack.add(v);
    }

    public static void main(String[] args)
    {
        Digraph G = new Digraph(6);
        G.addEdge(0, 3);
        G.addEdge(5, 1);
        G.addEdge(1, 3);
        G.addEdge(5, 0);
        G.addEdge(3, 2);
        System.out.println(G);
        ArrayList<Integer> orderedG = buildOrder(G);
        for (int i=orderedG.size()-1; i>=0; i--)
            System.out.format("%d ", orderedG.get(i));
        System.out.println();
    }
}