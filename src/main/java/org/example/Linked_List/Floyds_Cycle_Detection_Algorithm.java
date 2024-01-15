package org.example.Linked_List;
//package java.utils.*;

//The Floyd's Cycle Detection Algorithm, also known as the "Tortoise and the Hare" algorithm,
// is a pointer algorithm that uses two pointers, which move at different speeds,
// to detect a cycle in a sequence of values (like a linked list).
// In the context of a linked list, it can determine whether a cycle exists
// and also find the starting node of the cycle.

public class Floyds_Cycle_Detection_Algorithm {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class Solution {

        //checks for the presence of a cycle in the list
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode slow = head; // This is the "Tortoise"
            ListNode fast = head; // This is the "Hare"

            // Move slow pointer by 1 step and fast pointer by 2 steps
            while (fast != null && fast.next != null) {
                slow = slow.next;      // move slow by 1 step
                fast = fast.next.next; // move fast by 2 steps

                // If slow and fast meet at some point then there is a cycle
                if (slow == fast) {
                    return true;
                }
            }

            // If we reach here means there is no cycle
            return false;
        }

        //finds the starting node of the cycle if one exists.
        public ListNode detectCycleStart(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;
            boolean hasCycle = false;

            // First part is same as hasCycle
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    hasCycle = true;
                    break;
                }
            }

            // If there's a cycle, find the start node of the cycle
            if (hasCycle) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

            return null;
        }

        public static void main(String[] args) {
            // Example usage
            ListNode head = new ListNode(3);
            head.next = new ListNode(2);
            head.next.next = new ListNode(8);
            head.next.next.next = new ListNode(-4);
            head.next.next.next.next = new ListNode(1);
            head.next.next.next.next.next = new ListNode(5);
            head.next.next.next.next = head.next.next; // Create a cycle

            Solution solution = new Solution();
            boolean hasCycle = solution.hasCycle(head);
            ListNode cycleStart = solution.detectCycleStart(head);

            System.out.println("Has Cycle: " + hasCycle);
            System.out.println("Cycle starts at node with value: " + (cycleStart != null ? cycleStart.val : "No cycle"));
        }
    }

}
