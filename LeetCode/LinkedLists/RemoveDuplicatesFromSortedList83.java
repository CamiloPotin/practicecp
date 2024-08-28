package LeetCode.LinkedLists;/*
Remove Duplicates from sorted List 83 de leetcode

Problema:
Se quieren remover los duplicados de una list

Solucion:
Se recorre la lista y se agrega en una nueva solo cuando no se repite


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
    public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;

        int act = head.val; 
        ListNode result = new ListNode(act);
        ListNode headResult = result;
        head = head.next;

        while (head != null) {
            if (head.val != act) {
                act = head.val;
                result.next = new ListNode(act);
                result = result.next;
            }
            head = head.next;
        }

        return headResult;

    }
}
