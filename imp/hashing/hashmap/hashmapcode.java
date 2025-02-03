package imp.hashing.hashmap;

import java.util.*;

public class hashmapcode{
    static class HashMap<K,V>{//generics used
          private class Node {
          K key;
          V value;
          public Node(K key,V value){
            this.key=key;
            this.value=value;
          }           
          }
          private int n;
          private int N;
          private LinkedList<Node> buckets[];
          @SuppressWarnings("unchecked")
          //to suppress the warnings of the uncheked type of the datawhen ll created at line 21
          public HashMap(){
            this.N=4;
            this.n=0;
            this.buckets=new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i]=new LinkedList<>();
            }
          }
          private int hashfunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi)%N;
          }
          private int searchinll(K key,int bi){
            LinkedList<Node> ll=buckets[bi];
            int di=0;

            for (int i = 0; i < ll.size(); i++) {
                Node node=ll.get(i);
                if (node.key==key) {
                    return di;
                }
                di++;
            }
            return -1;
          }
          public void rehash(){
            LinkedList<Node> oldbucket[]=buckets;
            buckets=new LinkedList[2*N];
            N*=2;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i]=new LinkedList<>();
            }

            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll=oldbucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node=ll.remove();
                    put(node.key, node.value);
                }
            }
          }
          public void put(K key,V value){
            int bi=hashfunction(key);
            int di=searchinll(key,bi);
            if (di != -1) { 
                Node node = buckets[bi].get(di);
                node.value = value;
            } else { 
                buckets[bi].add(new Node(key, value)); 
                n++; 
            }            
            double lambda = (double) n / N;
            if(lambda>2){
                rehash();
            }
          }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("china", 150);
        hm.put("india", 100);
        hm.put("usa", 50);
        System.out.println(hm);

    }
    
}