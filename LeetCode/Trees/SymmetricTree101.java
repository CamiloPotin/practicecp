/*
101. Symmetric Tree

Problema:
Se quiere saber si un arbol es simetrico 

Solucion:
Es igual a "Same tree" pero a la hora de llamar a la funcion recursiva se cambian de lugar se envia con los hijos izquiedo de uno
y derecho del otro arbol

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
    public boolean isSymmetric(TreeNode root) {
 if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
         if(t1 == null && t2 == null)
            return  true;
        else if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;
        boolean left = isMirror(t1.left,t2.right);
        boolean right = isMirror(t2.left,t1.right);
       

        return left && right; 
    }
}
