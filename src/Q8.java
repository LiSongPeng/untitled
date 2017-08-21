import java.util.Stack;

//给定整数N,确定斐波那契数列的第N项
public class Q8 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fibonacci(30));
        System.out.println(System.currentTimeMillis()- start);
        System.out.println(fibonacci2(30));
        start=System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() -start);
        start=System.currentTimeMillis();
        System.out.println(fibonacci3(30));
        System.out.println(System.currentTimeMillis()-start);
    }

    //递归不可取,时间复杂度,空间复杂度增长太快
    public static int fibonacci(int n) {
        if (n < 2)//0,1
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        if (n < 2)
            return n;
        int first = 1;
        int second = 1;
        int temp = 0;
        for (int i = 3; i < n + 1; i++) {
            temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }

    public static int fibonacci3(int n) {
        if (n < 2)
            return n;
        Stack<Integer> stack = new Stack<>();
        while (n >= 2) {
            stack.push(-1);
            n--;
        }
        stack.push(1);
        stack.push(0);
        int first, second;
        while (stack.size() != 2) {
            first = stack.pop();
            second = stack.pop();
            stack.pop();
            stack.push(first + second);
            stack.push(second);
        }
        stack.pop();
        return stack.pop();
    }
}
