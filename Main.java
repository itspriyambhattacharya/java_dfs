import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices:\t");
        int n = Integer.parseInt(br.readLine()); // number of vertices

        System.out.println("Enter number of edges:\t");
        int e = Integer.parseInt(br.readLine()); // number of edges

        Graph g = new Graph(n); // creating a graph object

        for (int i = 0; i < e; i++) {
            System.out.println("Edge " + (i + 1));
            System.out.println("\nEnter source vertex:\t");
            int src = Integer.parseInt(br.readLine());
            System.out.println("\nEnter dest vertex:\t");
            int dest = Integer.parseInt(br.readLine());

            if (src < 0 || src >= g.getVertices() || dest < 0 || dest >= g.getVertices()) {
                System.err.println("Invalid edge, try again.....");
                i--;
                continue;
            }
            g.addEdge(src, dest); // adding edges to the graph
        }

        System.out.println("The graph is:\n");
        g.display(); // displaying the graph

        System.out.print("\nEnter a start vertex:\t");
        int start = Integer.parseInt(br.readLine());
        System.out.println("DFS Traversal is:\n");
        g.dfs(start); // fails if the connected graph contains more than one component

        for (int i = 0; i < g.getVertices(); i++) {
            if (!g.checkVisited(i)) {
                g.dfs(i);
            }
        }

        br.close();
    }
}
