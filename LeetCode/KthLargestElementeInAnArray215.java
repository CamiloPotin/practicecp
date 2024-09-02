/*
215. Kth Largest Element in an Array

Problema:
Se quiere saber cual es el k numero en orden descendente

Solucion:
Se usa una heap donde se guarda en la raiz el maximo y se devuelve el k valor guardado


*/



class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for(int i : nums){
        maxHeap.add(i);
    }
    for(int i = 0 ; i < k-1 ; i++)
        maxHeap.poll();

      return maxHeap.poll();
    }

  }
  
