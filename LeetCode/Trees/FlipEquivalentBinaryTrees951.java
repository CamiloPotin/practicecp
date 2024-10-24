/*
951. Flip Equivalent Binary Trees

Problema:
Se quiere saber si un arbol es equivalente a otro haciendo operaciones de flip entre sus nodos.

Solucion:
Se recorre el nodo y se compara si son iguales o si intercambiando son iguales devuelve verdadero


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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
              return flip(root1, root2);
    }

    private boolean flip(TreeNode root1, TreeNode root2) {
        // Si ambos nodos son nulos, son equivalentes
        if (root1 == null && root2 == null) {
            return true;
        }
        // Si solo uno de ellos es nulo, no son equivalentes
        if (root1 == null || root2 == null) {
            return false;
        }
        // Si los valores de los nodos son diferentes, no son equivalentes
        if (root1.val != root2.val) {
            return false;
        }

        // Comprobar si son equivalentes sin flip
        boolean noFlip = flip(root1.left, root2.left) && flip(root1.right, root2.right);
        // Comprobar si son equivalentes con flip
        boolean withFlip = flip(root1.left, root2.right) && flip(root1.right, root2.left);
        
        // Son equivalentes si son equivalentes sin flip o con flip
        return noFlip || withFlip;
    }
}
