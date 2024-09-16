/*
539. Minimum Time Difference

Problema:
Se quiere saber la minima diference entre cualquier hora dentro de un array de Strings que contiene horas en formato hh:mm

Solucion:
Se convierten las horas en una suma de minutos y se guarda en un arreglo de enteros, luego se ordena y se busca el minimo entre dos consecutivos


*/


import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> result = new ArrayList<>();

        // Convertir cada tiempo a minutos
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            result.add(h * 60 + m);
        }

        // Ordenar la lista de tiempos en minutos
        Collections.sort(result);

        int min = Integer.MAX_VALUE;

        // Calcular la diferencia mínima entre tiempos consecutivos
        for (int i = 1; i < result.size(); i++) {
            int diff = result.get(i) - result.get(i - 1);
            min = Math.min(min, diff);
        }

        // Calcular la diferencia entre el primer y último tiempo (para considerar el ciclo de 24 horas)
        int wrapAroundDiff = 1440 - result.get(result.size() - 1) + result.get(0);
        min = Math.min(min, wrapAroundDiff);

        return min;
    }
}
