/*
207. Course Schedule

Prolema:
Se quiere saber si se puede completar un curso, se tiene una lista de los prerequisitos y el numero de cursos
Un curso se puede terminar cuando no existen ciclos entre los prerequisitos

Solucion:
Se utiliza dfs buscando la existencia de un ciclo.

*/



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
             List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            grafo.add(new ArrayList<>());
        }

        // Llenar la lista de adyacencia con los prerrequisitos
        for (int[] prerequisite : prerequisites) {
            int curso = prerequisite[0];
            int prerequisito = prerequisite[1];
            grafo.get(prerequisito).add(curso); // prerequisito -> curso
        }

        // Arreglo de estados para detectar ciclos
        // 0 = no visitado, 1 = visitado temporalmente (en el ciclo actual), 2 = visitado permanentemente
        int[] estado = new int[numCourses];

        // Ejecutar DFS para cada curso
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, grafo, estado)) {
                return false; // Si encontramos un ciclo, no es posible terminar todos los cursos
            }
        }

        return true; // Si no se encontró ningún ciclo, se pueden completar todos los cursos
    }

    private boolean dfs(int curso, List<List<Integer>> grafo, int[] estado) {
        if (estado[curso] == 1) {
            return false; // Si el curso está siendo visitado temporalmente, encontramos un ciclo
        }

        if (estado[curso] == 2) {
            return true; // Si ya está visitado permanentemente, no es necesario volver a procesarlo
        }

        // Marcar el curso como visitado temporalmente
        estado[curso] = 1;

        // Recorrer los vecinos (cursos dependientes)
        for (int vecino : grafo.get(curso)) {
            if (!dfs(vecino, grafo, estado)) {
                return false; // Si encontramos un ciclo en algún vecino, retornamos false
            }
        }

        // Marcar el curso como visitado permanentemente
        estado[curso] = 2;
        return true;
    }
}
