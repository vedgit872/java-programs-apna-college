package imp.bit_manupalation;

public class modular_exponentiation {
    static int moduExpo(int x,int y,int z){
        int mod=x%z;
        while(y>0){
            if ((y & 1)!= 0) {
                mod=mod%z;
            }
            mod*=mod;
            y=y>>1;
        }
        return (int)Math.sqrt(mod);
    }
    public static void main(String[] args) {
        System.out.println(moduExpo(5, 1, 8));
    }
}
