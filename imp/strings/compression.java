package imp.strings;
import java.util.*;
public class compression {
    public static String comp(String s) {
        StringBuilder str=new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            int count=1;
            while (i<s.length()-1&&s.charAt(i)==s.charAt(i+1)) {
                count++;
                i++;
            }
            str.append(s.charAt(i));
            if(count>1){
                 str.append(count);
            }}
        return str.toString();
        // StringBuilder str=new StringBuilder("");
        // char ch=s.charAt(0);
        // int count=1;
        // for (int i = 1; i < s.length(); i++) {
        //     if(s.charAt(i)==ch){
        //         count++;
        //         if (i== s.length()-1) {
        //             str.append(ch);
        //         if(count>1){
        //             str.append(count);
        //         }
        //         count=1;
        //         ch=s.charAt(i);
        //         }
        //     }
        //     else{
        //         str.append(ch);
        //         if(count>1){
        //             str.append(count);
        //         }
        //         count=1;
        //         ch=s.charAt(i);
        //     }
        // }
        // return str.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(comp(sc.next()));
    }
}
