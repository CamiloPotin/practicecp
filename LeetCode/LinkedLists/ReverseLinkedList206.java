package LeetCode.LinkedLists;/*
Reverse Linked List 206 de leetcode

Problema:
Se quiere revertir una lista 

Solucion:
Se va intercambiando los punteros de lugar el que apuntaba al segundo nodo apunta a null y 
el next del segundo nodo apunta al primero

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
    public ListNode reverseList(ListNode head) {
       
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
       
    }
}
