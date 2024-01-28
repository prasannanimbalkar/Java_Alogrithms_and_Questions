package org.example.Linked_List.Problems;


//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class Intersection_of_two_linked_lists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check: If either list is null, there can be no intersection.
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize two pointers, 'a' and 'b', to the heads of the input linked lists.
        ListNode a = headA;
        ListNode b = headB;

        // Loop until 'a' and 'b' are either at the intersection node or both are null.
        while (a != b) {
            // Move 'a' to the next node in its list. If 'a' reaches the end of its list,
            // reset it to the head of the other list ('headB').
            a = (a == null) ? headB : a.next;

            // Move 'b' to the next node in its list. If 'b' reaches the end of its list,
            // reset it to the head of the other list ('headA').
            b = (b == null) ? headA : b.next;
        }

        // At this point, 'a' and 'b' either point to the intersection node or are both null
        // (indicating no intersection).

        // Return the intersection node (or null if there is no intersection).
        return a;
    }

    public static void main(String[] args) {
        // Create the linked lists
        ListNode commonNode = new ListNode(7);
        commonNode.next = new ListNode(8);

        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);
        listA.next.next = new ListNode(3);
        listA.next.next.next = commonNode;

        ListNode listB = new ListNode(4);
        listB.next = new ListNode(5);
        listB.next.next = commonNode;

        ListNode intersectionNode = getIntersectionNode(listA, listB);

        if (intersectionNode != null) {
            System.out.println("Intersection point value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}


//Initially, a and b are set to the heads of their respective linked lists (headA and headB).
//
//In each iteration of the loop, both a and b are moved one step forward in their respective linked lists.
// This is done using the next pointer, which points to the next node in the list.
//
//If a or b reaches the end of its respective list (i.e., it becomes null), it is reset to the head of the other list.
// This is achieved using the ternary operator a = (a == null) ? headB : a.next and b = (b == null) ? headA : b.next.
//
//The loop continues until a and b meet at the same node. When this happens, the condition a != b becomes false,
// and the loop exits.
//
//Finally, the code returns the node at which a and b meet, which is the intersection point.
// If there is no intersection, both a and b will become null simultaneously, and null will be returned.