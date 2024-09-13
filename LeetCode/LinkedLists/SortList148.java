/*
148. Sort List

Problema:
Se quiere ordenar una lista

Solucion:
Se ordena usando divide y conquistaras:
  -Se busca el medio y se llama recursivamente hasta que queden dos valores que se ordenan y dsps empieza a 
volver

*/



class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one element, return it as is.
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);  // Find the middle of the list
        ListNode rightHalf = mid.next;  // Start of the right half
        mid.next = null;  // End the left half by cutting the list

        // Step 2: Recursively sort each half
        ListNode left = sortList(head);  // Sort the left half
        ListNode right = sortList(rightHalf);  // Sort the right half

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Slow moves one step at a time, fast moves two steps
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return the node before the middle, so we can split the list correctly
        return prev;
    }


    // Function to merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the two lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If there are remaining elements in either list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }
}
