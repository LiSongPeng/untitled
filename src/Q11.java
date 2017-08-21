//试设计一个非递归算法在O(n)时间内将一个含有n个元素的单链表逆置,要求其辅助空间为常量
public class Q11 {
    public static void main(String[] args) {
        Node head = new Node();
        Node n1 = new Node();
        n1.value = 1;
        head.next = n1;
        Node n2 = new Node();
        n2.value = 2;
        n1.next = n2;
        Node n3 = new Node();
        n3.value = 3;
        n2.next = n3;
        Node n4 = new Node();
        n4.value = 4;
        n3.next = n4;
        Node n5 = new Node();
        n5.value = 5;
        n4.next = n5;
        n5.next = null;
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.next.value);
            temp = temp.next;
        }
        reverse(head);
        temp = head;
        while (temp.next != null) {
            System.out.println(temp.next.value);
            temp = temp.next;
        }
    }

    public static void reverse(Node head) {
        if (head.next == null || head.next.next == null)
            return;
        Node last = head.next, curr = head.next.next;
        Node temp = null;
        while (curr.next != null) {
            if (temp == null)
                last.next = null;
            temp = curr.next;
            curr.next = last;
            last = curr;
            curr = temp;
        }
        curr.next = last;
        head.next = curr;
    }

    public static class Node {
        public Node next;
        public int value = -1;
    }
}
