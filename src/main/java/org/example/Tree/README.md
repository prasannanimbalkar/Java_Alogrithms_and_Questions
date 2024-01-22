## Tree

[](//https://www.freecodecamp.org/news/all-you-need-to-know-about-tree-data-structures-bceacb85490c/)

A tree is a widely used hierarchical data structure in computer science and mathematics. It is a collection of nodes connected by edges, where each node has a parent (except for the root) and zero or more child nodes. Trees are essential in various applications and algorithms, including representing hierarchical relationships, organizing data efficiently, and facilitating searches and manipulations.

Here are some key concepts related to trees:

Root: The topmost node in a tree, which has no parent. It serves as the starting point for traversing the tree.

Node: Each element in a tree is called a node. Nodes contain data and are connected to other nodes through edges.

Edge: The lines or arrows connecting nodes in a tree. Edges represent the relationships between nodes.

Parent: A node in a tree that has one or more child nodes. The node above another node in the hierarchy is referred to as the parent node.

Child: A node in a tree that is connected to a parent node. It is located one level below the parent node.

Siblings: Nodes that share the same parent in a tree are called siblings.

Leaf: A node in a tree that has no children; it is a terminal node.

Depth: The depth of a node is the length of the path from the root to that node. The root node has a depth of 0.

Height: The height of a tree is the length of the longest path from the root to a leaf. It represents the maximum depth in the tree.

## Types of Trees:

Binary Tree: A tree in which each node has at most two children, referred to as the left child and the right child.
Binary Search Tree (BST): A binary tree where the left child of a node contains values less than or equal to the node's value, and the right child contains values greater than the node's value.
Balanced Tree: A tree in which the height of the left and right subtrees of any node differs by at most one. Examples include AVL trees and Red-Black trees.
Binary Heap: A specialized binary tree used in priority queues and heap-sort algorithms.
Trie (Prefix Tree): A tree used for storing and searching for strings with common prefixes, often used in dictionary-based applications.


## Common Operations on Trees:

Traversal: Visiting each node in a tree in a specific order. Common traversal methods include in-order, pre-order, post-order, and level-order traversal.
Insertion: Adding a new node to a tree.
Deletion: Removing a node from a tree.
Search: Finding a specific node or value in a tree.
Balancing (for balanced trees): Ensuring that the tree remains balanced after insertions and deletions.
Trees are versatile data structures with applications in various domains, such as databases, file systems, hierarchical data representation, and algorithms like binary search and tree-based sorting. They play a fundamental role in computer science and data structures.