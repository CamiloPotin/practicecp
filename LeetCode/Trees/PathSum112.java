/*
112. Path Sum

Problema:
Se quiere saber si se encuentra la suma de un determinado valor sumando los valores del arbol

Solucion:
Se va recorriendo recursivamente restando los valores del arbol a la suma y si se encuentra una hoja que coincide
con el valor de targetSum significa que existe la suma

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
    private int sum =0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if (root == null) return false;

        // Si es una hoja, verifica si el valor del nodo es igual a targetSum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Verifica el subárbol izquierdo y derecho con la suma restante
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
