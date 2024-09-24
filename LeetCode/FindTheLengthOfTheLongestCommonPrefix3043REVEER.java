/*
3043. Find the Length of the Longest Common Prefix

Problema:
Se quiere encontar la longitud de prefix mas grande entre dos arreglos de numereos

Solucion:
Se usa un trie y se convierte ambos a String

Chatgpt reveer

*/


class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            String str = Integer.toString(num);
            TrieNode node = root;

            for (char c : str.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
        }

        public int longestCommonPrefixLength(int num) {
            String str = Integer.toString(num);
            TrieNode node = root;
            int length = 0;

            for (char c : str.toCharArray()) {
                if (node.children.containsKey(c)) {
                    length++;
                    node = node.children.get(c);
                } else {
                    break;
                }
            }

            return length;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        // Insert all numbers from arr1 into the Trie
        for (int num : arr1) {
            trie.insert(num);
        }

        int maxLength = 0;

        // Check the longest common prefix for each number in arr2
        for (int num : arr2) {
            int commonLength = trie.longestCommonPrefixLength(num);
            maxLength = Math.max(maxLength, commonLength);
        }

        return maxLength;
    }
}
