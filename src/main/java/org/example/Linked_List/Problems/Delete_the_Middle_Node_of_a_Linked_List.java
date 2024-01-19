package org.example.Linked_List.Problems;



//Initialize two pointers: Both fast and slow start at the head of the list. fast moves twice as fast as slow.
//
//Traverse the list: As fast moves two steps at a time and slow moves one step at a time, when fast reaches the end of the list, slow will be at the middle.
//
//Delete the middle node: When slow is at the middle, we can remove the middle node by adjusting the next pointer of the previous node to skip the middle node.

public class Delete_the_Middle_Node_of_a_Linked_List {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteMiddle(ListNode head) {
        // If the list is empty or has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize two pointers
        ListNode slow = head, fast = head, prev = null;

        // Move 'fast' twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow; // Keep track of the node before 'slow'
            slow = slow.next; // 'slow' will be at the middle when 'fast' reaches the end
        }

        // Delete the middle node
        prev.next = slow.next;

        return head;
    }



    // Main method for testing
    public static void main(String[] args) {
        // Create a sample linked list and test the method
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = deleteMiddle(head);

        // Print the modified list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
