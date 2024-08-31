/*
530. Minimum Absolute Difference in BST

Problema:
Se quiere saber la diferencia absoluta entre dos nodos cualquiera de un arbol BST

SOlucion:
Se recorre in order guardando el nodo previo y comparando la resta con un min


*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

     private int min = Integer.MAX_VALUE;
    private Integer prev = null;  // Usamos Integer para manejar el caso inicial

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return min;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Travesía por el subárbol izquierdo
        inOrderTraversal(node.left);

        // Calcular la diferencia mínima con el nodo anterior
        if (prev != null) {
            min = Math.min(min, node.val - prev);
        }

        // Actualizar el valor del nodo anterior
        prev = node.val;

        // Travesía por el subárbol derecho
        inOrderTraversal(node.right);
    }
}
