public class Power2_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
    
    public static void main(String[] args) {
        Power2_231 solver = new Power2_231();

        int n1 = 1;
        int n2 = 16;
        int n3 = 18;

        System.out.println(n1 + " is power of two: " + solver.isPowerOfTwo(n1));
        System.out.println(n2 + " is power of two: " + solver.isPowerOfTwo(n2));
        System.out.println(n3 + " is power of two: " + solver.isPowerOfTwo(n3));
    }
}

