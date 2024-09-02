/*
1046. Last Stone Weight

Problema:
Se quiere saber cual es la piedra resultante al tener un arreglo de  n piedras con a[i] peso cada una 
Por cada tirada las dos piedras mayores chocan y si son iguales se destruyen y sino queda la diferencia entre ambas en el arreglo
esto se repite hasta que queda 1 piedra o 0 y se devuelve el resultado

Solucion:
Se usa una heap donde en la raiz se van guardando las maximas piedras y dsps se recorre la misma hasta que quede una sola piedra o ninguna

*/


class Solution {
    public int lastStoneWeight(int[] stones) {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for(int i : stones){
        maxHeap.add(i);
    }
    while(maxHeap.size()>=2){
        int num1 = maxHeap.poll();
        int num2 = maxHeap.poll();
        if(num1!=num2){
            maxHeap.add(num1-num2);
        }

    }
    return maxHeap.isEmpty() ? 0 : maxHeap.poll();
        
    }
}
