package imp.bit_manupalation;

public class count_set_bits {
    public static int countBits(int n){
        int count=0;
        for (int i = 0; (1<<i) <= n; i++) {
            if((n & (1<<i))!=0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countBits(7));
    }
    
}
