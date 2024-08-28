package LeetCode.ArraysAndStrings;
/*
Merge Intervals 56 de leetcode

Porblema:
Se tiene un arreglo de intervalos y se quiere devolver otro arreglo de intervalo pero sin que esten solapados.
Se deben encontrar los intervalos solapados y fusionar en uno.

Solucion:
La saque de un video.
Se ordena primero en base al primer elemento del intervalo.
Despues se recorre el arreglo de intervalos y se ultimo valor del nuevo arreglo de intervalors con el primer valor del intervalo actual 
para saber si existe solapamiento

*/
import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Sort intervals based on the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            // If the merged list is empty or there is no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // There is overlap, merge the intervals
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
