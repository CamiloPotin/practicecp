/*
108. Convert Sorted Array to Binary Search Tree

Problema:
Se quiere convertir un array ordenado ascendentemente en un arbol binario de busqueda

Solucion:
Se utiliza divide y conquista para resolverlo, se divide el arreglo a la mitad y se envia la parte izquierda al nodo izquierda
y la derecha al nodo derecho y asi continuamente hasta completar el arbol

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return newTree(nums,0,nums.length);
        
    }

    private TreeNode newTree(int[] nums, int start , int end){
        // Condición base: si el rango es inválido, retorna null
        if (start >= end) return null;

        // Calcular el índice del nodo medio
        int mid = start + (end - start) / 2;

        // Crear el nodo raíz con el valor medio
        TreeNode curr = new TreeNode(nums[mid]);

        // Construir el subárbol izquierdo con los elementos antes del medio
        curr.left = newTree(nums, start, mid);

        // Construir el subárbol derecho con los elementos después del medio
        curr.right = newTree(nums, mid + 1, end);

        return curr;

    }



}
