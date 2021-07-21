import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import java.lang.IllegalArgumentException;
interface Mat {
    public static String Who() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements[2];
        String all = new String();

        all += element.getClassName();
        all += '\n';
        all += element.getMethodName();
        return all;
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double fx = 0;
        double h = 1e-6, y = a;
        double n;
        n = ((b - a) / h);
        while (a <= b) {

            fx += f.applyAsDouble(a);
            a += h;

        }
        fx = fx * h;
        System.out.println(Who());
        return fx;
    }

    public static double sqrt(double x) throws IllegalArgumentException {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        } else {
            System.out.println(Who());
            return (Math.pow(x, 0.5));
        }
    }
}
public static class Main implements Mat {

    public static double sqrt(double x) throws IllegalArgumentException  {
        if (x < 0) {
           throw new IllegalArgumentException("Expected non-negative number, got " + x) ;
        }else{
            System.out.println(Who());
            return (Math.pow(x, 0.5));
        }

    }
        public static String Who(){
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement element = stackTraceElements[2];
            String all = new String();

            all += element.getClassName();
            all += '\n';
            all += element.getMethodName();
            return all;
        }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
       double a,b;

    a  = scan.nextDouble();
    b = scan.nextDouble();
    b = Mat.integrate((x)->1,a,b);
    a = Mat.sqrt(a);

        System.out.println(Who());


    }
}
