/*
241. Different Ways to Add Parentheses

Problema:
Se tiene un String con una expresion matematica y se quiere calcular todas las posibles combinaciones de operaciones que se pueden hacer y su resultado final se guarda en un arreglo
ej: "2-1-1" -> ((2-1)-1) = 0  (2-(1-1)) = 2  Output: [0,2]

Solucion:
Se usa recursion y memorizacion 
chatgpt


*/




class Solution {
     private Map<String, List<Integer>> memo = new HashMap<>();
     
    public List<Integer> diffWaysToCompute(String expression) {

        
    // Verificamos si ya tenemos el resultado almacenado
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        // Iteramos sobre la expresión
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // Si encontramos un operador
            if (c == '+' || c == '-' || c == '*') {
                // Dividimos la expresión en dos partes
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                // Evaluamos cada parte recursivamente
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                // Combinamos los resultados según el operador
                for (int leftResult : leftResults) {
                    for (int rightResult : rightResults) {
                        switch (c) {
                            case '+':
                                result.add(leftResult + rightResult);
                                break;
                            case '-':
                                result.add(leftResult - rightResult);
                                break;
                            case '*':
                                result.add(leftResult * rightResult);
                                break;
                        }
                    }
                }
            }
        }

        // Caso base: si no hay operadores, la expresión es un número
        if (result.isEmpty()) {
            result.add(Integer.valueOf(expression));
        }

        // Almacenamos el resultado en el mapa
        memo.put(expression, result);
        return result;
    }
}
