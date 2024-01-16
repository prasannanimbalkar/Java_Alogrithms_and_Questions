package org.example.Linked_List.Problems;

public class Odd_Even_Linked_List {

    // Definition for singly-linked list node.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }


    public static ListNode oddEvenList(ListNode head) {
        // If the list is empty or has only one node, there is nothing to rearrange.
        if (head == null) return null;

        // Initialize pointers.
        // 'odd' will iterate over the odd nodes.
        // 'even' will iterate over the even nodes.
        // 'evenHead' is the head of the even list and is used for linking at the end.
        ListNode odd = head, even = head.next, evenHead = even;

        // Traverse the list
        while (even != null && even.next != null) {
            // Connect the current odd node to the next odd node
            odd.next = even.next;
            odd = odd.next;

            // Connect the current even node to the next even node
            even.next = odd.next;
            even = even.next;
        }

        // Connect the last odd node to the head of the even list
        odd.next = evenHead;

        // Return the head of the modified list
        return head;
    }


    // Main method to execute the code
    public static void main(String[] args) {
        // Create a sample list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        Solution solution = new Solution();
        head = oddEvenList(head);

        // Print the rearranged list
        System.out.print("Rearranged List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
