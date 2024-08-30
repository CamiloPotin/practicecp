/*
230. Kth Smallest Element in a BST

Problema:
Se quiere encontrar el K elemento minimo en un arbol BST

Solucion:
Se recorre el arbol in order y se tiene dos variabbles de clase que se van contando
hata llegar a K y se guarda el resultado

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
  

    private int result = -1;
     private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Recorrer el subárbol izquierdo
        inorderTraversal(node.left, k);

        // Incrementar el contador al visitar el nodo actual
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Recorrer el subárbol derecho
        inorderTraversal(node.right, k);
    }
}
