package imp.tries;
import java.util.*;

public class tries{
    static class Node{
        Node[] children=new Node[26];
        boolean eow=false; //endOfWord=

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
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean search(String word){
        Node curr=root;
        for (int level = 0; level < word.length(); level++) {
            int idx=word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow;
    }
    public static void main(String[] args) {
        String arr[]={"the","a","there","their","any","three"};
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        System.out.println(search("there"));
        System.out.println(search("ther"));
    }
}