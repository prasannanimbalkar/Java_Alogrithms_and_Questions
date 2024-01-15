package org.example.Linked_List.Problems;

public class Delete_Node_in_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //SOLUTION
    public static void deleteNode(ListNode node) {

        // Cannot delete the last node or a null node.
        if (node == null || node.next == null) {
            return;
        }
        // Copy the value of the next node into the current node.
        node.val = node.next.val;
        // Update the current node's next pointer.
        node.next = node.next.next;
    }



    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode nodeToDelete = head.next.next; // Node with value 3

        System.out.println("Original Linked List:");
        printLinkedList(head);

        deleteNode(nodeToDelete);

        System.out.println("Linked List after deleting node with value 3:");
        printLinkedList(head);
    }
}
