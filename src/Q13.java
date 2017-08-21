import java.util.Stack;

//计算前N项之和. 1+1/2-1/3+1/4-1/5.... 给出递归和非递归算法
public class Q13 {
    public static void main(String[] args) {
        System.out.println(recursive(3));
        System.out.println(nonRecursive(3));
    }

    public static double recursive(int n) {
        if (n == 1)
            return 1;
        if (n % 2 == 0)
            return (double) 1 / n + recursive(n - 1);
        else
            return -(double) 1 / n + recursive(n - 1);
    }

    public static double nonRecursive(int n) {
        double result = 0;
        Stack<Double> stack = new Stack<>();
        while (n > 1) {
            if (n % 2 == 0) {

            } else {

            }
            n--;
        }
        return result + n;
    }
}
