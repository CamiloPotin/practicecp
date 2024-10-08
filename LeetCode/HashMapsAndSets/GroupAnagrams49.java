package LeetCode.HashMapsAndSets;/*
Group Anagrams 49 de leetcode

Problema:
Se tiene un array de Strings y se quiere devolver un arreglo con distintos arreglos de Strings que contienen cada arreglo los anagramas posibles.

Solucion:
Se recorre el arreglo y por cada String se ordena el mismo y se va almacenando en un HashMap en el que la llave es la palabra ordenada
y el valor es un arreglo de Strings.
Luego se devuelve todos los valores del HashMap.


*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

         // Crear un HashMap para almacenar las listas de anagramas
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterar sobre cada palabra en la lista
        for (String str : strs) {
            // Convertir la palabra a un array de caracteres, ordenarlo y convertirlo de nuevo a cadena
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            // Si la clave no está en el mapa, agregarla con una nueva lista
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            
            // Agregar la palabra a la lista correspondiente en el mapa
            map.get(sortedStr).add(str);
        }
        
        // Devolver las listas de anagramas como una lista de listas
        return new ArrayList<>(map.values());
        
    }
}
