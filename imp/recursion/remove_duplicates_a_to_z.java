package imp.recursion;

public class remove_duplicates_a_to_z {
    public static void remove_duplicates(StringBuilder s,String s1,int i,boolean map[]){
           if (i==s1.length()) {
                System.out.println(s);
                return;
           }
           char ch=s1.charAt(i);
           if(!map[ch-'a']){
            s.append(ch);
            map[ch-'a']=true;
           }
           remove_duplicates(s, s1, i+1, map);
    }
    public static void main(String[] args) {
        boolean map[]=new boolean[26];
        StringBuilder s=new StringBuilder("");
        remove_duplicates(s, "appnacollege", 0, map);
    }
}
