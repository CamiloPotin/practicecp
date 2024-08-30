/*
543. Diameter of Binary Tree

Problema:
Se tiene un arbol binario y se quiere saber la distancia mas lejana entre dos nodos

Solucion:
Se guarda el diametro en una variable de la clase y se calcula las distancias entre nodos y 
se compara con el diametro actual



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
   private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calcula la altura del subárbol izquierdo y derecho
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Calcula el diámetro pasando por el nodo actual
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Retorna la altura del nodo actual
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
