package org.example.Linked_List.Problems;

public class Sort_List {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }




    // Main function to sort the linked list
    public static ListNode sortList(ListNode head) {
        // Base cases: if the list is empty or has only one element, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the linked list
        ListNode middle = findMiddle(head);

        // Split the linked list into two halves
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        // Recursively sort the two halves
        left = sortList(left);
        right = sortList(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Helper function to find the middle of the linked list
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted linked lists
    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // If there are remaining elements in either of the lists, append them
        if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }






    // Helper function to print the linked list for testing
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);


        // Sort the linked list
        ListNode sortedList = sortList(head);

        // Print the sorted linked list
        printList(sortedList);
    }
}
