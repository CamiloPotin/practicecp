package LeetCode.LinkedLists;/*
Merge Two Sorted Lists 21 de leetcode

Problema:
Se quiere fusionar dos listas ordenadas en una

Solucion:
Se recorre las dos listas y se va agregando en base a cual de los dos es mayor al otro
luego si quedan elementos de cualquiera de las dos listas se agregan al final del resultado


*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result = new ListNode();
        ListNode headResult = result;

        while (list1 != null && list2 != null) {
            int num1 = list1.val;
            int num2 = list2.val;

            if (num1 <= num2) {
                result.next = new ListNode(num1);
                list1 = list1.next;
            } else {
                result.next = new ListNode(num2);
                list2 = list2.next;
            }
            result = result.next;
        }

        if (list1 != null) {
            result.next = list1;
        } else if (list2 != null) {
            result.next = list2;
        }

        return headResult.next;
    }
}
