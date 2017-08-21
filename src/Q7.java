//生成窗口最大值数组
public class Q7 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        for (int i : generate(arr, 4))
            System.out.println(i);
    }

    public static int[] generate(int[] arr, int windowSize) {
        int[] res = new int[arr.length - windowSize + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - windowSize + 1; i++) {
            for (int j = i; j < windowSize + i; j++) {
                if (arr[j] > max)
                    max = arr[j];
            }
            res[i] = max;
            max = Integer.MIN_VALUE;
        }
        return res;
    }
}
