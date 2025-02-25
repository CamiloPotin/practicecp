/*
1524. Number of Sub-arrays With Odd Sum

Problema:
Se quiere calcular la cantidad de subarreglos que dan suma impar

Solucion:
Se hace prefixSum y se va calculando si la suma actual es par o impar se suma al total la cantidad total de sumas anteiores
*/



class Solution {
    public int numOfSubarrays(int[] arr) {
         int evenCount = 1; // Contamos el caso donde la suma del sub-arreglo es impar desde el principio
        int oddCount = 0;
        int currentSum = 0;
        long  result = 0;

        for (int num : arr) {
            currentSum += num;

            // Verificamos si la suma actual es par o impar
            if (currentSum % 2 == 0) {
                result += oddCount;  // Si es par, contamos los sub-arreglos donde la suma de prefijo era impar
                evenCount++;         // Incrementamos el contador de prefijos pares
            } else {
                result += evenCount; // Si es impar, contamos los sub-arreglos donde la suma de prefijo era par
                oddCount++;          // Incrementamos el contador de prefijos impares
            }
            result = result % 1000000007;
        }

        return (int) result;
    }


    }
