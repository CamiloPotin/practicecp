/*
1971. Find if Path Exists in Graph

Problema:
Se quiere saber si existe o no un camino valido entre un nodo origen y uno destino para un grafo bidireccional

Solucion:
Se usa dfs marcando los nodos visitados
(Chatgpt revisar bien)

*/


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
          // Crear una lista de adyacencia para representar el grafo
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grafo.add(new ArrayList<>());
        }
        
        // Llenar la lista de adyacencia
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            grafo.get(u).add(v);
            grafo.get(v).add(u);
        }
        
        // Usaremos un arreglo para marcar los nodos visitados
        boolean[] visitado = new boolean[n];
        
        // Ejecutar DFS para ver si existe un camino del nodo 'inicio' al nodo 'fin'
        return dfs(source, destination, grafo, visitado);
    }
    
    private boolean dfs(int nodo, int fin, List<List<Integer>> grafo, boolean[] visitado) {
        if (nodo == fin) {
            return true; // Si llegamos al nodo destino, existe un camino
        }
        
        visitado[nodo] = true; // Marcar el nodo actual como visitado
        
        // Recorrer todos los vecinos del nodo actual
        for (int vecino : grafo.get(nodo)) {
            if (!visitado[vecino]) {
                // Si encontramos un camino desde algún vecino, retornamos true
                if (dfs(vecino, fin, grafo, visitado)) {
                    return true;
                }
            }
        }
        
        return false; // Si no se encuentra un camino, retornamos false
    }
}
