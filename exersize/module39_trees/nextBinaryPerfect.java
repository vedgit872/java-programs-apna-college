package exersize.module39_trees;

import java.util.LinkedList;
import java.util.Queue;

public class nextBinaryPerfect {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {
            if (root == null)
                return root;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            bfs(q);
            return root;
        }

        void bfs(Queue<Node> q) {
            if (q.isEmpty())
                return;
            Queue<Node> nq = new LinkedList<>();
            while (!q.isEmpty()) {
                Node root = q.poll();
                if (!q.isEmpty())
                    root.next = q.peek();
                if (root.left != null)
                    nq.add(root.left);
                if (root.right != null)
                    nq.add(root.right);
            }
            bfs(nq);
        }
    }
}
