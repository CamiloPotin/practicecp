## Tener en cuenta para resolver problemas de arboles:

### Dos tipos de recorrido:
- Recursivo:
```java
       if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Visitar el nodo
        preOrder(node.left);              // Recorrer el subárbol izquierdo
        preOrder(node.right);             // Recorrer el subárbol derecho
```


- Por niveles:
```java
    if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll(); // Sacamos el nodo del frente de la cola
            System.out.print(currentNode.val + " "); // Visitamos el nodo

            // Agregamos el hijo izquierdo a la cola si existe
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // Agregamos el hijo derecho a la cola si existe
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
```


### Recordar los tipos de recorrido
  - Pre order:
      Nodo -> Subárbol izquierdo -> Subárbol derecho.
  - In order:
     Subárbol izquierdo -> Nodo -> Subárbol derecho.
  - Pos order:
    Subárbol izquierdo -> Subárbol derecho -> Nodo.

### Tener en cuenta:
- Se pueden usar variables de clase cuando hay que llevar un calculo que implica nodos alejados entre sí
- Cuando se devuelve una variable de clase en vez de lo que retorna el metodo recursivo se puede usar dos metodos 
