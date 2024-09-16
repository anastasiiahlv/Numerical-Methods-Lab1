import static java.lang.Math.*;

public class SimpleIterationMethod {

    public static void method(double epsilon) {
        double x_n;
        double x_n_next = -1.95;
        double result = 0;
        int iterationCount = 0;
        boolean is_result = false;

        System.out.printf("%-15s %-20s %-20s %-20s\n", "Iteration", "x_n", "|x_n - x_n-1|", "f(x_n)");

        for (int i = 1; i <= 20; i++) {
            x_n = x_n_next;
            x_n_next = funcIter(x_n);

            System.out.printf("%-15d %-20.15f %-20.15f %-20.15e\n",
                    i,
                    x_n_next,
                    Math.abs(x_n_next - x_n),
                    func(x_n_next));

            if (Math.abs(x_n_next - x_n) <= epsilon && !is_result) {
                iterationCount = i;
                is_result = true;
                result = x_n_next;
                break;
            }
        }

        if (is_result) {
            System.out.println("n(E) = " + n_e(-1.95, epsilon));
            System.out.println("Result is found during " + iterationCount + " iteration");
            System.out.println("x = " + result + " f(x) = " + func(result));
        } else {
            System.out.println("Solution is not found within 20 iterations.");
        }
    }

    public static double func(double x) {
        return x * x + 4 * sin(x);
    }

    public static double funcIter(double x) {
        return -sqrt(-4 * sin(x));
    }

    public static double n_e(double x, double e) {
        double q = 0.44;
        double z = 0.02235; // |φ(x0) - x0|

        return ((Math.log(z/((1-q)*e)))/(Math.log(1/q))) + 1;
    }
}
