import java.util.Stack;

//用栈来求解汉诺塔问题
//不能直接从左侧移动到右侧,或直接从右侧移动到左侧,只能先移动到中间位置
public class Q6 {
    public static void main(String[] args) {
        System.out.println("It will move " + hanoiTower(3, "left", "mid", "right") + " steps");
    }

    //递归方式
    public static int hanoiTower(int n, String source, String medium, String dest) {
        int sum = 0;
        if (n == 1) {
            System.out.println("move " + n + " from " + source + " to " + medium);
            System.out.println("move " + n + " from " + medium + " to " + dest);
            sum += 2;
        } else {
            sum += hanoiTower(n - 1, source, medium, dest);
            System.out.println("move " + n + " from " + source + " to " + medium);
            sum += hanoiTower(n - 1, dest, medium, source);
            System.out.println("move " + n + " from " + medium + " to " + dest);
            sum += hanoiTower(n - 1, source, medium, dest);
            sum += 2;
        }
        return sum;
    }
}

