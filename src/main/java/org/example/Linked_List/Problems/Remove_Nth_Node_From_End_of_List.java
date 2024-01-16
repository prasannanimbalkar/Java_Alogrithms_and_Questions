package org.example.Linked_List.Problems;

//https://www.youtube.com/watch?v=XVuQxVej6y8

//Initialization:
//
//Two pointers, fast and slow, are both initialized to the head of the linked list.
//Advancing the Fast Pointer:
//
//The fast pointer is advanced n steps ahead in the list. This creates a gap of n nodes between the fast and slow pointers. If the fast pointer reaches the end of the list (null) during this step, it indicates that the head of the list is the node to be removed. In this case, the head is removed by returning head.next.
//Moving Both Pointers Together:
//
//Both fast and slow pointers are then moved together one step at a time until fast reaches the end of the list. When fast is at the last node, slow will be positioned just before the node that needs to be removed. This is because of the n node gap maintained between fast and slow.
//Removing the Target Node:
//
//The node following the slow pointer is the one that needs to be removed. This is achieved by updating the next pointer of the slow node to skip the next node (i.e., slow.next = slow.next.next). This effectively removes the nth node from the end of the list.
//Returning the Modified List:


public class Remove_Nth_Node_From_End_of_List {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize two pointers: 'fast' and 'slow', both starting at the head of the list
        ListNode fast = head, slow = head;

        // Move 'fast' pointer n steps ahead to create a gap of n nodes between 'fast' and 'slow'
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If 'fast' is null, it means we need to remove the head of the list
        if (fast == null) return head.next;

        // Move both 'fast' and 'slow' until 'fast' reaches the last node
        // At this point, 'slow' will be right before the node to be removed
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the node by skipping it. Now, 'slow.next' is the node to be removed
        slow.next = slow.next.next;

        // Return the head of the modified list
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

        head = removeNthFromEnd(head, 2);

        // Print the modified list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
