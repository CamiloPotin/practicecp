/*
2530. Maximal Score After Applying K Operations

Problema:
Se quiere ver la mayor suma posible de nums[i] valores para k sumas, luego de agregar un valor se reemplaza
el valor de nums[i] por ceil(nums[i]/3)

Solucion:
Se usa una maxHeap, se almacenan los valores y dsps se hace k sumas con los maximos de la heap
*/


class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < nums.length ; i++) {
            maxHeap.add(nums[i]);
        }
        long result = 0;
        for(int i = 0 ; i < k ; i++){
            int num = maxHeap.poll();
            result+= num;
            num = (int) Math.ceil(num / 3.0);
            maxHeap.add(num);
        }
        return result;
    }
}
