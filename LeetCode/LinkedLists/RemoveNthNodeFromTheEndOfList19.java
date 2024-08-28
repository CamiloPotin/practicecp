package LeetCode.LinkedLists;/*
Remove Nth Node from the end of list 19 de leetcode

Problema:
Se quiere borrar el nodo N contando desde el final de la lista

Solucion:
 Se usa el mismo enfoque de dos punteros lento y rapido, el rapido empieza a contar desde N
 por lo que cuando el rapido se encuentre al final de la lista el slow estara en la posicion N

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
    public ListNode removeNthFromEnd(ListNode head, int n) {

          ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Mueve `fast` `n+1` posiciones adelante
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Mueve ambos punteros hasta que `fast` llegue al final
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // `slow` ahora apunta al nodo justo antes del que necesitamos eliminar
        slow.next = slow.next.next;

        // Retorna la lista, considerando si eliminamos el primer nodo
        return dummy.next;
        
    }
}
