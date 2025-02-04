package imp.hashing.hashmap;

import java.util.*;

public class hashmapcode {
    static class HashMap<K, V> { // Generics used
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        // To suppress the warnings of the unchecked type of data when LL created
        public HashMap() {
            this.N = 4;
            this.n = 0;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashfunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        private int searchinll(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) { // Fixed key comparison using .equals()
                    return di;
                }
                di++;
            }
            return -1;
        }

        public void rehash() {
            LinkedList<Node> oldbucket[] = buckets;
            buckets = new LinkedList[2 * N];
            N *= 2;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll = oldbucket[i];
                while (!ll.isEmpty()) { // Fixed rehashing logic
                    Node node = ll.removeFirst();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashfunction(key);
            int di = searchinll(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2) {
                rehash();
            }
        }

        public V get(K key) {
            int bi = hashfunction(key);
            int di = searchinll(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public boolean isContains(K key) {
            int bi = hashfunction(key);
            int di = searchinll(key, bi);
            return di != -1;
        }

        public V remove(K key) {
            int bi = hashfunction(key);
            int di = searchinll(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keyset() {
            ArrayList<K> arr = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    arr.add(node.key);
                }
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("china", 150);
        hm.put("india", 100);
        hm.put("usa", 50);

        // Keyset iteration example
        System.out.println("HashMap Contents:");
        for (String key : hm.keyset()) {
            System.out.println(key + " -> " + hm.get(key));
        }
    }
}
