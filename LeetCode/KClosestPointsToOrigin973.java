/*
973. K Closest Points to Origin

Problema:
Se quiere saber los puntos x,y mas cercanos al origen 0,0 se usa la formula:
  sqrt((x1-x0)**2 + (y1-y0)**2) para saber la distancia entre dos puntos

Solucion:
Se hace la heap donde se guardan puntos x,y y en la comparacion se compara las distancias
*/



class Solution {
    public int[][] kClosest(int[][] points, int k) {

         PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        // Agregar los puntos al heap
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Mantener sólo los k puntos más cercanos en la heap
            }
        }

        // Convertir el heap a un array de puntos
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
     // Método para calcular la distancia cuadrada al origen
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
