package imp.strings;

public class largest {
    public static void main(String[] args) {
        String s[]={"apple","Banana","Mango"};
        String lar=s[0];float val;//largest ,value after comparison
        for (int i = 1; i < s.length; i++) {
            val=lar.compareToIgnoreCase(s[i]);
            if (val<0) {
                lar=s[i];
            }
        }
        System.out.println(lar);
    }
}
