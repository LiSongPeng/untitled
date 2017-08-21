import java.util.Stack;

//实现一个特殊功能的栈,可以返回当前栈中最小元素的值
//要求：pop,push,getMin操作时间复杂度为O(1)
public class Q1 {
    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.push(10);
        minStack.push(11);
        minStack.push(1);
        minStack.push(8);
        minStack.push(13);
        System.out.println(minStack.getMin());
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
    }

    public static class MinStack<T> {
        private Stack<T> data;
        private Stack<T> min;

        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(T item) {
            data.push(item);
            if (min.size() == 0 || ((Comparable) item).compareTo(min.peek()) <= 0)
                min.push(item);
        }

        public T pop() {
            T top = data.pop();
            if (((Comparable) top).compareTo(min.peek()) == 0)
                min.pop();
            return top;
        }

        public T getMin() {
            return min.peek();
        }
    }
}
