
class PowerOfTwo {
    static boolean isPowerOfTwo(int n) {
        double m = Math.sqrt(Math.abs(n));
        return (m - (double)((int)m)) == 0.;
    }

    public static void main(String[] args) {
        int n = 4;
        if(isPowerOfTwo(n))
            System.out.println(n + " est une puissance de 2");
        else
            System.out.println(n + " n'est pas une puissance de 2");

        n = 5;
        if(isPowerOfTwo(n))
            System.out.println(n + " est une puissance de 2");
        else
            System.out.println(n + " n'est pas une puissance de 2");

        n = 16;
        if(isPowerOfTwo(n))
            System.out.println(n + " est une puissance de 2");
        else
            System.out.println(n + " n'est pas une puissance de 2");
    }
}