
## GRAPHS

[](https://www.programiz.com/dsa/graph)

A graph is a fundamental data structure used to represent relationships or connections between objects. It consists of a set of nodes (vertices) and a set of edges that connect pairs of nodes. Graphs are widely used in various domains, including computer science, mathematics, and real-world applications, to model and analyze various types of relationships and networks.

Here are some key concepts related to graphs:

Node (Vertex): Each element in a graph is called a node or vertex. Nodes can represent entities, objects, or data points.

Edge: An edge is a connection or relationship between two nodes. It represents the link between nodes and can have associated attributes or weights.

Directed Graph (Digraph): In a directed graph, edges have a direction, indicating a one-way relationship from one node to another. It means that you can traverse an edge from one node to another but not necessarily in the reverse direction.

Undirected Graph: In an undirected graph, edges have no direction, meaning that the relationship between nodes is bidirectional. If there is an edge between nodes A and B, you can traverse it in both directions.

Weighted Graph: A weighted graph is a graph in which each edge has an associated weight or cost. These weights can represent distances, costs, or any other numerical value.

Path: A path in a graph is a sequence of nodes connected by edges. It represents a route or sequence of relationships from one node to another.

Cycle: A cycle is a path in which the starting node and ending node are the same. It forms a closed loop within the graph.

Connected Graph: A graph is connected if there is a path between every pair of nodes. In other words, you can reach any node from any other node in the graph.

Disconnected Graph: A graph is disconnected if it has one or more isolated components, meaning that there is no path between some pairs of nodes.

Acyclic Graph: A graph that does not contain any cycles is called an acyclic graph. Directed acyclic graphs (DAGs) are commonly used in various algorithms and data structures.

Degree: The degree of a node is the number of edges connected to it. In a directed graph, nodes have an in-degree (incoming edges) and an out-degree (outgoing edges).

Subgraph: A subgraph is a subset of nodes and edges of a graph that forms a valid graph.

## Types of Graphs:

Tree: A special type of graph with no cycles, where each node has a parent (except for the root) and zero or more children.
Complete Graph: A graph in which there is an edge between every pair of distinct nodes.
Bipartite Graph: A graph whose nodes can be divided into two sets, and there are no edges between nodes within the same set.
Sparse Graph: A graph with relatively few edges compared to the maximum possible edges.
Dense Graph: A graph with many edges, where most node pairs are connected.

## Common Operations on Graphs:

Traversal: Visiting nodes and edges in a specific order, such as depth-first search (DFS) and breadth-first search (BFS).
Shortest Path: Finding the shortest path between two nodes in a weighted graph (e.g., Dijkstra's algorithm).
Connectivity: Determining whether a graph is connected or finding connected components.
Cycle Detection: Identifying cycles within a graph.
Topological Sorting: Ordering nodes in a directed acyclic graph (DAG) such that for every directed edge (u, v), node u comes before node v in the order.
Minimum Spanning Tree: Finding the subset of edges that connects all nodes in a weighted graph with the minimum total weight (e.g., Prim's algorithm and Kruskal's algorithm).
