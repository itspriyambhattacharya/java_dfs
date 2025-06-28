import java.util.ArrayList;
import java.util.List;

public class Graph {
    // Attributes
    private int vertices; // number of vertices
    private int adjm[][];
    private List<Integer> visited;
    private List<Integer> dfsNo;
    private List<Integer> dfsCompNo;
    public static int ds = 0; // start time
    public static int dc = 0; // end time

    // Constructor
    public Graph(int v) {
        this.vertices = v;
        visited = new ArrayList<>();
        dfsNo = new ArrayList<>();
        dfsCompNo = new ArrayList<>();
        adjm = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                adjm[i][j] = 0;
            }
            visited.add(0);
            dfsNo.add(0);
            dfsCompNo.add(0);
        }
    }

    // Methods
    public int getVertices() {
        return this.vertices;
    }

    public boolean checkVisited(int v) {
        int res = visited.get(v);
        if (res == 1) {
            return true;
        }
        return false;
    }

    public void addEdge(int src, int dest) {
        this.adjm[src][dest] = 1; // considering directed graph
    }

    public void display() {
        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                System.out.print(adjm[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void dfs(int start) {
        System.out.print(start + "\t");
        dfsNo.set(start, ++ds);
        visited.set(start, 1);

        for (int i = 0; i < this.vertices; i++) {
            if (adjm[start][i] == 1 && visited.get(i) == 0) {
                dfs(i);
            }
        }
        dfsCompNo.set(start, ++dc);
    }
}