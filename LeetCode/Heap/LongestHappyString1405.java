/*
1405. Longest Happy String

Problema:
Se tiene enteros representando el numero de letras a,b,c y se quiere crear un String que cumpla:
s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.

Solucion:
Se guarda la cantidad de letras en la heap y se va formando el String con la de mayor frecuencia
si hay dos ocurrencias seguidas se agrega la segunda mas frecuente y asi hasta finalizar.

*/

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        // Insertamos las letras con sus respectivas cantidades en el heap
        if (a > 0) maxHeap.offer(new int[] {'a', a});
        if (b > 0) maxHeap.offer(new int[] {'b', b});
        if (c > 0) maxHeap.offer(new int[] {'c', c});

        StringBuilder result = new StringBuilder();

      
        while (!maxHeap.isEmpty()) {
            // Extraemos el carácter más frecuente
            int[] first = maxHeap.poll();
        
            // Si el anterior carácter utilizado es el mismo y se agregó 2 veces, lo agregamos a la siguiente opción
             if (result.length() >= 2 && result.charAt(result.length() - 1) == first[0] &&
                result.charAt(result.length() - 2) == first[0]){ 
                
                if (maxHeap.isEmpty()) break;
                
                int[] second = maxHeap.poll();
                result.append((char) second[0]);
                second[1]--;
                if (second[1] > 0) maxHeap.offer(second);
                // Reinsertamos el carácter anterior que fue pausado
                maxHeap.offer(first);
             
            } else {
                // Añadimos el carácter más frecuente
                result.append((char) first[0]);
                first[1]--;

                if (first[1] > 0) maxHeap.offer(first);
               
            }
            
        }

        return result.toString();
    }
    
    
}
