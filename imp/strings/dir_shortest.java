package imp.strings;
import java.util.*;

public class dir_shortest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String dir=sc.next();
        int h=0,v=0;//horizontal and vertical can also do x and y
        for (int i = 0; i < dir.length(); i++) {
            if(dir.charAt(i)=='E')
                h++;
            else if(dir.charAt(i)=='W')
            h--;
            else if(dir.charAt(i)=='N')
            v++;
            else
            v--;
        }
        System.out.println(Math.sqrt(h*h+v*v));
    }
}
