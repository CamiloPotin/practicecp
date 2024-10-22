/*
71. Simplify Path

Problema:
Se tiene un String que contiene un path hacia un archivo y se quiere simplificar (leer reglas en el problema)

Solucion:
Se usa split de String para dividir por "/" y se recorre procesando segun las reglas
y agregando a una stack los validos. Al final se recorre la stack armando el path resultado

*/


class Solution {
    public String simplifyPath(String path) {
     Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Ignore empty or current directory
                continue;
            } else if (component.equals("..")) {
                // Go to the parent directory
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Add the directory to the stack
                stack.push(component);
            }
        }

        // Construct the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // If the stack is empty, return root "/"
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();


    }
}
