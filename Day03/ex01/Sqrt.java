
class Sqrt {

    static float mySqrt(int n) {
        float x = n;
        float y = 1;
        double e = 0.00000001;

        while (x - y > e) {
            x = (x + y) / 2;
            y = n / x;
        }

        return y;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
}