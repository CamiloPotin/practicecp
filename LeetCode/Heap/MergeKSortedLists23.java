/*
23. Merge k Sorted Lists

Problema:
Se quiere ordenar k listas ordenadas y devolver una unica lista

Solucion:
Usando una heap de listas se recorre las listas agregando solo el primer elemento a la heap
Luego se guarda la raiz de la heap y se almacena el siguiente de esa lista


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
       public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Inicializar la heap con los primeros nodos de cada lista
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        
        return dummy.next;
    }
}
