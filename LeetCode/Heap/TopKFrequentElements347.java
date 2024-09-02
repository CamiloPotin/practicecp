/*
347. Top K Frequent Elements

Problema:
Se quiere saber los k elementos mas frecuenctes de un arreglo

Solucion:
Primero se guarda las frecuencias de los numeros en un map y dsps se pasa a una cola de prioridad en donde se ordena
por las mayores frecuencias
por ultimo se guarda hasta k elementos en la heap y se pasan al arreglo final

*/

class Solution {
      public int[] topKFrequent(int[] nums, int k) {
        // Crear un HashMap para contar las frecuencias de los elementos
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Crear una min heap que mantenga los k elementos más frecuentes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        // Agregar los elementos al heap
        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Mantener sólo los k elementos más frecuentes en la heap
            }
        }

        // Convertir el heap a un array de enteros
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
