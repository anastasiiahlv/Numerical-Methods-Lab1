import static java.lang.Math.*;

public class ModifiedNewtonMethod {
    public static void method(double epsilon) {
        double x_n;
        double x_n_next = -1.95;
        double result = 0;
        int iterationCount = 0;
        boolean is_result = false;

        System.out.printf("%-15s %-20s %-20s %-20s\n", "Iteration", "x_n", "|x_n - x_n-1|", "|f(x_n)|");

        for (int i = 1; i <= 20; i++) {
            x_n = x_n_next;
            x_n_next = x_n - func(x_n) / funcDerivative(-1.95);

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

    public static double funcDerivative(double x) {
        return 2 * x + 4 * cos(x);
    }

    public static double n_e(double x, double e) {
        double m1 = 5.09;
        double M2 = 5.79;
        double z = 0.05;
        double q = (M2 * z)/(2 * m1);

        return Math.log(((Math.log(0.05/e)/Math.log(1/q)) + 1)/Math.log(2)) + 1;
    }
}
