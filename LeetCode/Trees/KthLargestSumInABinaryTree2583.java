/*
2583. Kth Largest Sum in a Binary Tree

Problema:
Se quiere saber la k suma mas grande de un arbol con suma de niveles

Solucion:
Se recorre bfs y se suma por cada nivel y luego se guarda en una maxheap luego se devuelve el k valor


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
    private int max = 0;
    private int max2=0;
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return 0;
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long currentLevelSum = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            minHeap.offer(currentLevelSum);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
           if (minHeap.size() < k) return -1;
        
        return minHeap.peek();
    }

    
}
