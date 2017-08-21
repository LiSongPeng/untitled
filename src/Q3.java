import java.util.Stack;

//如何仅用递归函数和栈操作来逆序一个栈
//栈中元素1,2,3,4,5,逆序后,5,4,3,2,1.仅能用递归函数和栈操作.
public class Q3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
        while (stack.size() > 0)
            System.out.println(stack.pop());
    }

    public static Object getAndRemoveLast(Stack stack) {
        /*Object result = stack.pop();
        if (stack.isEmpty())
            return result;
        else {
            Object last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }*/
        return stack.remove(0);
    }

    public static void reverseStack(Stack stack) {
        if (stack.isEmpty())
            return;
        Object o = getAndRemoveLast(stack);
        reverseStack(stack);
        stack.push(o);
    }
}

