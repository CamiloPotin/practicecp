/*
210. Course Schedule II

Problema:
Se quiere saber si es posible terminar un curso, se tiene n cursos y un arreglo con los prerequisitos para cada curso
Se debe calcualr si existe un ciclo no es posible terminar el curso y si no existe devolver el orden en el que se deben hacer

Solucion:
Es como 207. Course Schedule pero agregando un arreglo

*/


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
          // Crear una lista de adyacencia para representar el grafo
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            grafo.add(new ArrayList<>());
        }

        // Llenar la lista de adyacencia
        for (int[] prerequisito : prerequisites) {
            int curso = prerequisito[0];
            int prerequisitoCurso = prerequisito[1];
            grafo.get(prerequisitoCurso).add(curso);
        }

        // Arreglo para rastrear el estado de cada nodo: 0 = no visitado, 1 = temporal, 2 = procesado
        int[] estado = new int[numCourses];
        List<Integer> ordenTopologico = new ArrayList<>();

        // Realizar DFS en cada curso
        for (int i = 0; i < numCourses; i++) {
            if (estado[i] == 0) {
                if (!dfs(grafo, estado, i, ordenTopologico)) {
                    return new int[0]; // Si encontramos un ciclo, devolvemos un arreglo vacío
                }
            }
        }

        // Convertir la lista a un array y revertirla para obtener el orden correcto
        Collections.reverse(ordenTopologico);
        return ordenTopologico.stream().mapToInt(i -> i).toArray();
    }

    // DFS para recorrer el grafo
    private boolean dfs(List<List<Integer>> grafo, int[] estado, int curso, List<Integer> ordenTopologico) {
        // Si el nodo está en estado temporal, significa que hemos encontrado un ciclo
        if (estado[curso] == 1) {
            return false;
        }

        // Si ya está procesado, no necesitamos hacer nada
        if (estado[curso] == 2) {
            return true;
        }

        // Marcar el nodo como visitado temporalmente
        estado[curso] = 1;

        // Explorar todos los vecinos (cursos dependientes)
        for (int vecino : grafo.get(curso)) {
            if (!dfs(grafo, estado, vecino, ordenTopologico)) {
                return false;
            }
        }

        // Marcar el nodo como procesado permanentemente
        estado[curso] = 2;

        // Agregar el curso al orden topológico (postorden)
        ordenTopologico.add(curso);

        return true;
    }
}
