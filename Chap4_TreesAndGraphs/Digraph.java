/*
* directed graph implementation using adjacency list
* */
import java.util.*;
import java.io.File;
import java.lang.IndexOutOfBoundsException;
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;

public
class Digraph {
    private final int                   V;
    private       int                   E;
    private       LinkedList<Integer>[] adj;

    /*
    * create an empty digraph with V vertices
    * */
    public
    Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) { adj[i] = new LinkedList<Integer>(); }
    }

    /*
    * create a digraph from input stream
    * */
    public
    Digraph(Scanner in) {
        this(in.nextInt()); // create an empty graph
        int E = in.nextInt();
        if (E < 0) throw new IllegalArgumentException("Number of edge must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    /*
    * throw exception if v is out of bound
    * */
    private
    void validateVertex(int v) {
        if (v < 0 || v > V) throw new IndexOutOfBoundsException("vertex " + v + " is not in graph");
    }

    /*
    * add a directed edge v→w
    * */
    public
    void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        E++;
    }

    /*
    * vertices pointing from v
    * */
    public
    Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /*
    * number of vertices
    * */
    public
    int V() {
        return V;
    }

    /*
    * number of edges
    * */
    public
    int E() {
        return E;
    }

    /*
    * reverse of this digraph
    * */
    public
    Digraph reverse() {
        Digraph reverseG = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) { reverseG.addEdge(w, v); }
        }
        return reverseG;
    }

    /*
    * string representation
    * */
    public
    String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v + " : ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static
    void main(String[] args) throws Exception
    {
        try
        {
            Scanner in = new Scanner(new File(args[0])).useDelimiter("\\s");
            Digraph G  = new Digraph(in);
            System.out.println(G);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}