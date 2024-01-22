package org.example.Graph;

import java.util.*;

//https://visualgo.net/en/sssp
//https://www.freecodecamp.org/news/dijkstras-shortest-path-algorithm-visual-introduction/#:~:text=Dijkstra's%20Algorithm%20finds%20the%20shortest,node%20and%20all%20other%20nodes.

//Time Complexity 	 O((V + E) * log(V)), V is the number of vertices in the graph. E is the number of edges in the graph.
//log(V) represents the time taken for each insertion and extraction operation in the priority queue (min-heap).

//Space Complexity	 O(V + E))


//Dijkstra's Algorithm finds the shortest path between a given node (which is called the "source node") and all other nodes in a graph.


//We create a Graph class to represent the graph with weighted edges and an Edge class to represent edges with weights.
//
//We add weighted edges to the graph using the addEdge method. For an undirected graph, we add edges in both directions.
//
//The dijkstra function implements Dijkstra's algorithm to find the shortest distances from the source node to all other nodes.
//
//We use a priority queue (min-heap) to select the node with the smallest distance for exploration at each step.
//
//The algorithm initializes the shortest distances to infinity and updates them as it finds shorter paths.
//
//Finally, it returns an array of shortest distances from the source node to all other nodes.

public class Dijkstra_Algorithm {
    public static void main(String[] args) {
        // Create a graph with 6 vertices and add weighted edges
        // graph image in png
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 2);


        int source = 1; // Define the source node

        // Find the shortest distances from the source node to all other nodes
        int[] shortestDistances = dijkstra(graph, source);

        // Print the shortest distances from the source node
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("Shortest distance from node " + source + " to node " + i + ": " + shortestDistances[i]);
        }
    }

    // Define a Graph class to represent the graph with weighted edges
    static class Graph {
        int vertices;
        List<Edge>[] adjList;

        Graph(int v) {
            vertices = v;
            adjList = new ArrayList[v];
            for (int i = 0; i < v; ++i) {
                adjList[i] = new ArrayList<>();
            }
        }

        // Add a weighted edge to the graph
        void addEdge(int from, int to, int weight) {
            adjList[from].add(new Edge(to, weight));
            adjList[to].add(new Edge(from, weight)); // For undirected graphs, add reverse edge
        }
    }

    // Define an Edge class to represent edges with weights
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Implement Dijkstra's algorithm to find shortest distances
    static int[] dijkstra(Graph graph, int source) {
        System.out.println(graph.vertices);
        int[] shortestDistances = new int[graph.vertices];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE); // Initialize distances to infinity
        shortestDistances[source] = 0; // Distance to the source is 0

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        minHeap.add(new Edge(source, 0));

        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            int currentNode = currentEdge.to;

            // Iterate through neighbors of the current node
            for (Edge neighbor : graph.adjList[currentNode]) {
                int potentialDistance = shortestDistances[currentNode] + neighbor.weight;

                // If a shorter path is found, update the distance and add to the min-heap
                if (potentialDistance < shortestDistances[neighbor.to]) {
                    shortestDistances[neighbor.to] = potentialDistance;
                    minHeap.add(new Edge(neighbor.to, potentialDistance));
                }
            }
        }

        return shortestDistances;
    }
}
