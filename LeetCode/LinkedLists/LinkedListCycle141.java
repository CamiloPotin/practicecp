package LeetCode.LinkedLists;/*
Linked List Cycle 141 de leetcode

Problema:
Se quiere saber si una lista es circular o no

Solucion:
Hay dos posibles soluciones:
  -Una de orden espacial O(n) que se usa un Set de ListNodes y si se encuentra en el set el nodo actual es true
  - Una de orden espacial O(1) que usa un algoritmo The Fast & Slow pointer approach

*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
              ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }
}
