import java.util.Stack;

//编写一个类,用两个栈实现队列,支持队列的基本操作,add,poll,peek
public class Q2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(15);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

    public static class Queue<T> {
        private Stack<T> first;
        private Stack<T> second;

        public Queue() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void add(T item) {
            first.push(item);
        }

        public T poll() {
            if (second.size() == 0) {
                while (first.size() > 0)
                    second.push(first.pop());
            }
            return second.pop();
        }

        public T peek() {
            if (second.size() > 0)
                return second.lastElement();
            return first.firstElement();
        }
    }
}
