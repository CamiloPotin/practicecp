/*
572. Subtree of Another Tree

Problema:
Se quiere saber si un arbol es un subarbol de otro

Solucion:
Se usa el algoritmo ya hecho isSameTree y se llama iterarivamente desde otra funcion con los hijos del arbol y el subarbol


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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
      if (root == null) return false;
        
        // Verifica si el árbol subRoot es igual al subárbol de root
        if (isSameTree(root, subRoot)) return true;
        
        // Busca en el subárbol izquierdo y derecho
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        
        // Verifica que los subárboles izquierdo y derecho sean iguales
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
