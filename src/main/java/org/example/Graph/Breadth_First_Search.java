package org.example.Graph;
import java.util.LinkedList;
import java.util.Queue;

//https://visualgo.net/en/sssp

//Time Complexity 	 O(V + E), where V is the number of vertices (nodes) and E is the number of edges in the graph
//Space Complexity	 O(V + E), where V is the space for the visited array, and E is the space for the adjacency list


//We define a Graph class that represents a graph as an adjacency list.
//We create a simple graph with seven vertices and add edges to it.
//The bfs function is used to perform a breadth-first traversal starting from a given source vertex.
// It uses a queue to keep track of the vertices to be visited.
//The visited array is used to mark visited vertices to avoid revisiting them.
//The BFS traversal prints the vertices in the order they are visited, starting from the source vertex (in this case, vertex 0).

public class Breadth_First_Search {
    public static void main(String[] args) {
        // Create a graph with 7 vertices
        Graph graph = new Graph(7);

        // Add edges to the graph to create connections between vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
//        graph.addEdge(4, 7);
//        graph.addEdge(4, 8);

        //graph
        //     0
        //    / \
        //   1   2
        //  / \ / \
        //  3 4 5 6

        // Perform BFS starting from vertex 0
        System.out.println("Breadth-First Traversal starting from vertex 0:");
        bfs(graph, 0);
    }

    // Define a Graph class to represent the graph as an adjacency list
    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int v) {
            vertices = v;
            adjList = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adjList[i] = new LinkedList<>();
            }
        }

        // Add an edge to the graph connecting two vertices
        void addEdge(int v, int w) {
            adjList[v].add(w);
        }
    }

    // Implement BFS traversal function
    static void bfs(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.vertices]; // Create an array to track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Create a queue to manage vertices to be visited

        visited[startVertex] = true; // Mark the starting vertex as visited
        queue.add(startVertex); // Add the starting vertex to the queue

        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue a vertex from the front of the queue
            System.out.print(vertex + " "); // Print the visited vertex

            // Iterate through the adjacent vertices of the current vertex
            for (Integer neighbor : graph.adjList[vertex]) {
                if (!visited[neighbor]) { // If the neighbor is not visited
                    visited[neighbor] = true; // Mark it as visited
                    queue.add(neighbor); // Add it to the queue for further exploration
                }
            }
        }
    }
}
