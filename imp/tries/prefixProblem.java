package imp.tries;

public class prefixProblem {
    static class Node{
        Node[] children=new Node[26];
        boolean eow=false; //endOfWord=
        boolean unique=true;

        public Node(){
            for (int i = 0; i < 26; i++) {
                children[i]=null;
            }
        }
    }
    public static Node root=new Node(); 
    public static void insert(String word){
        Node curr=root;
        for (int level = 0; level < word.length(); level++) {
            int idx=word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                curr.children[idx]=new Node();
            }else
            curr.children[idx].unique=false;
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
   
    public static String uniquePrefix(String word){
        Node curr=root;
        for (int level = 0; level < word.length(); level++) {
            int idx=word.charAt(level)-'a';
            if (curr.children[idx].unique==true) {
                return word.substring(0, level+1);
            }
            curr=curr.children[idx];
        }
        return word;
    }
    public static void main(String[] args) {
        String arr[]={"zebra","dog","duck","dove","zoo"};
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
           System.out.println(uniquePrefix(arr[i]));
        }

    }
}
