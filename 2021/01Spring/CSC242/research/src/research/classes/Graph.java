package research.classes;

import java.util.*;

// Graph class
public class Graph {
    private int Vertices;   // No. of vertices

    // adjacency list declaration
    private LinkedList<Integer> adj_list_int[];

    // node of adjacency list
    static class Node {
        int value, weight;
        Node(int value, int weight)  {
            this.value = value;
            this.weight = weight;
        }
    };

// define adjacency list

    List<List<Node>> adj_list_node = new ArrayList<>();

    //Graph Constructor
    public Graph(List<Edge> edges) {
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list_node.add(i, new ArrayList<>());

        // add edges to the graph
        for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj_list_node.get(e.src).add(new Node(e.dest, e.weight));
        }
    }

    public Graph(int v) {
        Vertices = v;
        adj_list_int = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj_list_int[i] = new LinkedList();
    }

    // print adjacency list for the graph
    public static void printGraph(Graph graph)  {
        int src_vertex = 0;
        int list_size = graph.adj_list_node.size();

        System.out.println("The contents of the graph:");
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Node edge : graph.adj_list_node.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.value +
                        " (" + edge.weight + ")\t");
            }

            System.out.println();
            src_vertex++;
        }
    }

    public void addEdge(int v, int w) {
        adj_list_int[v].add(w);  // Add w to v's list.
    }

    // helper function for DFS technique
    public void DFS_helper(int v,boolean visited[]) {
        // current node is visited
        visited[v] = true;
        System.out.print(v+" ");

        // process all adjacent vertices
        Iterator<Integer> i = adj_list_int[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFS_helper(n, visited);
        }
    }
}