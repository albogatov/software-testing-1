package cos;

public class Cosine {
    public static double cos(double x, int n) {
        double PI2 = Math.PI * 2;

        if (x >= 0) {
            while (x > PI2) {
                x -= PI2;
            }
        } else if (x < 0) {
            while (x < PI2) {
                x += PI2;
            }
        }

        double result = 1;

        double xx = x * x;
        double pow = xx;
        double fact = 1;

        int sign = -1;

        for (int i = 2; i < n; i += 2){
            fact /= i;
            result += sign * pow * fact;    // (-1)^(n-1) * x^(2n-2) / (2n-2)!
            sign = -sign;
            fact /= (i + 1);
            pow *= xx;
        }

        return result;

    }
}
