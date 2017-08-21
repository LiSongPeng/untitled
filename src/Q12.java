//循环队列
public class Q12 {
    public static void main(String[] args) {
        CirculationQueue<Integer> queue = new CirculationQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.isFull());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }

    public static class CirculationQueue<T> {
        private Object[] data;
        private int front;
        private int rear;
        private int capacity;

        public CirculationQueue(int initSize) {
            data = new Object[initSize];
            capacity = initSize;
            front = rear = 0;
        }

        public boolean enqueue(T item) {
            if ((rear - front) < capacity) {
                data[(rear++) % capacity] = item;
                return true;
            }
            return false;
        }

        public T dequeue() {
            if (rear - front > 0) {
                return (T) data[(front++) % capacity];
            }
            return null;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public int size() {
            return rear - front;
        }

        public boolean isFull() {
            return rear - front == capacity;
        }
    }
}
