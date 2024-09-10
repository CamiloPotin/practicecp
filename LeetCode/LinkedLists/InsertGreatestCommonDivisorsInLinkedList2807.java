
/*
2807. Insert Greatest Common Divisors in Linked List

Problema:
Se quiere insertar el gcd como nodo entre medio de los dos valores de una lista

Solucion:
Se consigue los dos valores de la lista y se calcula el gcd, luego se inserta en medio de ambos.

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
    
    ListNode first = head;
    while(head.next != null){
        int a = head.val;
        int b = head.next.val;
        int result = gcd(a,b);
        ListNode curr = new ListNode(result,head.next);
        head.next = curr;
        head = curr.next;

    }
    return first;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
