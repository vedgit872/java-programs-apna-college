
class test {

    public static int phi(int n) {
        // 1. Initialize result as n
        int result = n;

        // 2. Iterate through all possible prime factors up to sqrt(n)
        for (int p = 2; p * p <= n; p++) {
            // If p is a prime factor of n
            if (n % p == 0) {
                // Remove all occurrences of this prime factor from n
                while (n % p == 0) {
                    n /= p;
                }
                // Apply the formula: result = result * (1 - 1/p)
                result -= result / p;
            }
        }

        // 3. Handle the case where n is a prime number greater than sqrt(n)
        // (This is the remaining value of n after the loop)
        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    public static void main(String[] args) {
        int number = 12;
        System.out.println("phi(" + number + ") = " + phi(number)); // Output: phi(12) = 4

        number = 13;
        System.out.println("phi(" + number + ") = " + phi(number));// Output: phi(13) = 12
        System.out.println((int) Math.sqrt(20));
        int b = 198;
        byte l = (byte) (b & 15);
        int h = (b & 240);
        System.out.println((l << 4 | h >> 4));

    }
}
