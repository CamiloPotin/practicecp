package LeetCode.LinkedLists;/*
Middle of the linked list 876 de leetcode

Problema:
Se quiere encontrar el nodo que se encuentra en la mitad de la lista

Solucion:
  Existen dos soluciones como el problema anterior de listas
  - Una de orden O(n) recorre toda la lista contando los valores y dsps la recorre de nuevo hasta la mitad de los valores contados
  - El otro usa el The Fast & Slow pointer approach ya que uno de los punteros se mueve al doble de velocidad entonces cuando este llegue al final de la lista
   el puntero lento estara en la mitad de la misma. Este enfoque es O(n) tmb



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
    public ListNode middleNode(ListNode head) {
        /*
    ListNode aux = head;
    int n =  0;
    while(aux!=null){
        aux= aux.next;
        n++;
    }
    int count = 0;
    while(count<n/2){
        head = head.next;
        count++;
    }
    return head;
        */
         ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
