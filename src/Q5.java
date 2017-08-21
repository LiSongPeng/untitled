import java.util.Stack;

//用一个栈完成另一个栈的排序
//
public class Q5 {
    /*    public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> temp = new Stack<>();
            stack.push(3);
            stack.push(5);
            stack.push(1);
            stack.push(4);
            stack.push(2);
            stack.push(11);
            stack.push(22);
            stack.push(12);
            int min = Integer.MAX_VALUE;
            int size = stack.size();
            int t = 0;
            while (size > 1) {
                for (int i = 0; i < size; i++) {
                    t = stack.pop();
                    temp.push(t);
                    if (t < min)
                        min = t;
                }
                stack.push(min);
                while (temp.size() > 0) {
                    t = temp.pop();
                    if (t != min)
                        stack.push(t);
                }
                size--;
                min=Integer.MAX_VALUE;
            }
            while (stack.size() > 0)
                System.out.println(stack.pop());
        }*/
//方法2
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        int temp;
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(11);
        stack.push(11);
        stack.push(22);
        stack.push(12);
        while (stack.size() > 0) {
            temp = stack.pop();
            if (help.size() == 0 || temp <= help.peek())
                help.push(temp);
            else if (temp > help.peek()) {
                while (help.size() > 0)
                    stack.push(help.pop());
                help.push(temp);
            }
        }
        while (help.size() > 0)
            stack.push(help.pop());
        while (stack.size() > 0)
            System.out.println(stack.pop());
    }
}
