package imp.recursion;

public class print_binary_strings {
    public static void printbinstr(int n,int lastplace,String s){
        if (n==0) {
            System.out.println(s);
            return;
        }
        printbinstr(n-1, 0, s+"0");
        if (lastplace==0) {         
            printbinstr(n-1, 1, s+"1");
        }    }
        public static void printbinstrbui(int n,int lastplace,StringBuilder s){
            if (n==0) {
                System.out.println(s);
                return;
            }
            printbinstrbui(n-1, 0, s.append("0"));
            s.deleteCharAt(s.length() - 1); 
            if (lastplace==0) {         
                printbinstrbui(n-1, 1, s.append("1"));
                s.deleteCharAt(s.length() - 1); 
            }  
          }
        public static void main(String[] args) {
            StringBuilder s=new StringBuilder("");
            printbinstr(3, 0, "");
            printbinstrbui(3, 0, s);
        }
}
