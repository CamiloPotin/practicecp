/*
219. Contains Duplicate II

Problema:
Se quiere saber si un numero contiene dos indices i, j tales que nums[i]== nums[j] y abs(i-j)<=k

Solucion:
Se va guardando en el map y si contiene el numero se hace el calculo en caso de que de devuelve true

*/


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
   Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // Verificar si la diferencia de índices es menor o igual a k
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true; // Se encontró un duplicado cercano
                }
            }
            // Actualizar el índice del número actual
            map.put(nums[i], i);
        }
        return false; // No se encontraron duplicados cercanos
    }
}
