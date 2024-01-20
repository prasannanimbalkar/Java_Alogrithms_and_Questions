package org.example.Searching;

import java.util.ArrayList;
import java.util.List;

public class Depth_First_Search {
    public static void main(String[] args) {
        // Create a sample graph represented as an adjacency list
        int numVertices = 7;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 1, 4);
        addEdge(adjList, 2, 5);
        addEdge(adjList, 2, 6);

        // Perform DFS starting from vertex 0
        boolean[] visited = new boolean[numVertices];
        System.out.println("Depth-First Traversal (starting from vertex 0):");
        dfs(adjList, 0, visited);
    }

    public static void addEdge(List<List<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph, add this line
    }

    public static void dfs(List<List<Integer>> adjList, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, visited);
            }
        }
    }
}
