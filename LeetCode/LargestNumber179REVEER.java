/*
179. Largest Number

Problema:
Se quiere calcular el numero mas grande posible que se puede formar al 
juntar varios numeros dentro de un arreglo y devolver el numero como un String
Ej : [2,10] -> numero mas grande 210

Solucion:
Se convierte los numeros a String y se ordena comparando x+y con y+x luego  se concatena el arreglo ordenado

(chatgpt revisar)
*/



class Solution {
    public String largestNumber(int[] nums) {
           // Convertir números a cadenas
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        // Ordenar con un comparador personalizado
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // Comparar x+y con y+x
                return (y + x).compareTo(x + y);
            }
        });
       
        // Si el primer número es "0", el resultado es "0"
        if (numsStr[0].equals("0")) {
            return "0";
        }

        // Concatenar los números ordenados
        StringBuilder largestNum = new StringBuilder();
        for (String num : numsStr) {
            largestNum.append(num);
        }

        return largestNum.toString();
    }
}
