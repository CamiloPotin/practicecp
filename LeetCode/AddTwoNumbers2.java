/*
2. Add Two Numbers

Problema:
Se quiere sumar dos listas que continen los digitos de dos numeros y retornar una lista con el resultado final de la suma de los dos numeros

Solucion:
Se recorre ambas listas sumando y mantiendo un carry mientras se agregaba a la lista resultado
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Nodo ficticio para el resultado
        ListNode current = dummyHead; // Nodo actual para construir la lista resultante
        int carry = 0; // Llevar el valor de la suma

        // Iterar mientras haya nodos en l1 o l2 o haya un carry
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // Obtiene el valor de l1 o 0 si l1 es null
            int val2 = (l2 != null) ? l2.val : 0; // Obtiene el valor de l2 o 0 si l2 es null

            // Calcula la suma total de los valores actuales y el carry
            int sum = val1 + val2 + carry;

            // Calcula el nuevo carry y el valor del nodo actual
            carry = sum / 10;
            current.next = new ListNode(sum % 10);

            // Avanza al siguiente nodo en la lista resultante
            current = current.next;

            // Avanza a los siguientes nodos en l1 y l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // Retorna la lista resultante sin el nodo ficticio
    }
}
