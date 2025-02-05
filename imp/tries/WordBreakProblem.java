package imp.tries;

public class WordBreakProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; // endOfWord=

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    public static boolean wordbreak(String check){
        if (check.length()==0) {
            return true;
        }
        for (int i =1 ; i <= check.length(); i++) {//last index in excluded from substring
            if(search(check.substring(0, i))&&wordbreak(check.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        System.out.println(wordbreak("ilikesamsung"));
        System.out.println(wordbreak("ilikesamsun"));
    }
}
