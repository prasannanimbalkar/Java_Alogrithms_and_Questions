package org.example.Graph;
import java.util.LinkedList;
import java.util.Stack;

//https://visualgo.net/en/sssp

//Recursive

//We create a Graph class to represent the graph using an adjacency list data structure.
//We add edges to the graph using the addEdge method.
//The dfs function initializes an array called visited to keep track of visited vertices and
// then calls the recursive DFS function dfsRecursive.
//The dfsRecursive function implements the depth-first traversal recursively.
// It marks the current vertex as visited, prints it, and then recursively explores its unvisited neighbors.
//The DFS traversal starts from the specified source vertex (in this case, vertex 0),
// and it prints the visited vertices in the order they are visited.


//Itrative

//We create a Graph class to represent the graph using an adjacency list data structure.
//We add edges to the graph using the addEdge method.
//The iterativeDFS function initializes an array called visited to keep track of
// visited vertices and uses a stack for iterative DFS.
//The iterative DFS traversal starts from the specified source vertex
// (in this case, vertex 0) and uses a stack to keep track of vertices to be visited.
//It pops vertices from the stack, marks them as visited, and pushes
// their unvisited neighbors onto the stack for further exploration.
//The DFS traversal prints the visited vertices in the order they are visited.

public class Depth_First_Search {
    public static void main(String[] args) {
        // Create a graph with 7 vertices
        Graph graph = new Graph(8);

        // Add edges to the graph to create connections between vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdgeBiDirectional(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
//        graph.addEdge(4, 7);
//        graph.addEdge(4, 8);

        //graph
        //       0
        //     /  \
        //   1 <-> 2
        //  / \   / \
        //  3 4   5 6

        // Perform Recursive DFS starting from vertex 0
        System.out.println("Depth-First Traversal starting from vertex 0:");
        dfs(graph, 2);


        // Perform iterative DFS starting from vertex 0
        System.out.println("Iterative Depth-First Traversal starting from vertex 0:");
        dfsIterative(graph, 0);
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
        //this is unidirectional graph edge
        void addEdge(int v, int w) {
            adjList[v].add(w);
        }

        //this is bidirectional graph edge
        void addEdgeBiDirectional(int v, int w) {
            adjList[v].add(w);
            adjList[w].add(v);

        }
    }

    // Implement Recursive DFS traversal function using recursion
    static void dfs(Graph graph, int vertex) {
        boolean[] visited = new boolean[graph.vertices]; // Create an array to track visited vertices
        dfsRecursive(graph, vertex, visited); // Start the recursive DFS from the specified vertex
    }

    static void dfsRecursive(Graph graph, int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the current vertex as visited
        System.out.print(vertex + " "); // Print the visited vertex

        // Iterate through the adjacent vertices of the current vertex
        for (Integer neighbor : graph.adjList[vertex]) {
            if (!visited[neighbor]) { // If the neighbor is not visited
                dfsRecursive(graph, neighbor, visited); // Recursively visit the neighbor
            }
        }
    }



    // Implement iterative DFS traversal function
    static void dfsIterative(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.vertices]; // Create an array to track visited vertices
        Stack<Integer> stack = new Stack<>(); // Create a stack for iterative DFS

        stack.push(startVertex); // Push the starting vertex onto the stack

        while (!stack.isEmpty()) {
            int vertex = stack.pop(); // Pop a vertex from the stack

            if (!visited[vertex]) {
                visited[vertex] = true; // Mark the current vertex as visited
                System.out.print(vertex + " "); // Print the visited vertex

                // Push unvisited neighbors onto the stack in reverse order
                for (int i = graph.adjList[vertex].size() - 1; i >= 0; i--) {
                    int neighbor = graph.adjList[vertex].get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
