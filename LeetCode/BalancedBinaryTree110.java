/*

110. Balanced Binary Tree

Problema:
Se quiere saber si un arbol esta balanceado (dif <=1 entre los hijos)

Solucion:
Se calcula la altura de los hijos y si da mayor a 1 devuelve false


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
    public boolean isBalanced(TreeNode root) {


         return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;  // No está balanceado

        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;  // No está balanceado

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;  // No está balanceado

        return Math.max(leftHeight, rightHeight) + 1;
        
    }
}
