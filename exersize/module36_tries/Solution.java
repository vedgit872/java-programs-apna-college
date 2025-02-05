package exersize.module36_tries;

import java.util.Arrays;

class Solution {
    private static class Node {
        private char data;
        private String word;
        private boolean isEnd;
        private Node[] children;

        public Node(char data) {
            this.data = data;
            this.word = null;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }

    private Node root = new Node('/');
    private String ans = "";

    private void insert(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new Node(word.charAt(i));
            }
            curr = curr.children[childIdx];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    private void dfs(Node node) {
        if (node == null) return;

        if (node.isEnd) { // Only consider complete words
            if (node.word.length() > ans.length()) {
                ans = node.word;
            } else if (node.word.length() == ans.length() && node.word.compareTo(ans) < 0) {
                ans = node.word;
            }
        }

        for (Node child : node.children) {
            if (child != null && child.isEnd) { // Ensure only valid words are considered
                dfs(child);
            }
        }
    }

    public String longestWord(String[] words) {
        ans = ""; // Reset for each test case
        for (String word : words) {
            insert(word);
        }
        dfs(root);
        return ans;
    }
}
