//给定一个矩阵m,从左上角开始走到右下角,每次只能向右或向下走,路径上所有数字的累加就是路径和,求最小路径和
//动态规划问题
public class Q9 {
    static int[][] m = {
            {1, 3, 5, 9, 7},
            {8, 1, 3, 4, 6},
            {5, 0, 6, 1, 3},
            {8, 8, 4, 0, 6},
            {7, 8, 4, 4, 0}
    };
    static int[][] min = new int[m.length][m.length];

    public static void main(String[] args) {
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min.length; j++)
                min[i][j] = -1;
        }
        min[m.length - 1][m.length - 1] = 0;
        long start = System.currentTimeMillis();
        System.out.println(calcu(0, 0));
        System.out.println(System.currentTimeMillis() - start);
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min.length; j++)
                min[i][j] = -1;
        }
        min[m.length - 1][m.length - 1] = 0;
        start = System.currentTimeMillis();
        System.out.println(calcuNonRecursive(0, 0));
        System.out.println(System.currentTimeMillis() - start);
    }

    //递归方式
    public static int calcu(int row, int col) {
        if (min[row][col] == -1) {
            if (row == m.length - 1)
                min[row][col] = m[row][col] + calcu(row, col + 1);
            else if (col == m.length - 1)
                min[row][col] = m[row][col] + calcu(row + 1, col);
            else
                min[row][col] = Math.min(m[row][col] + calcu(row + 1, col), m[row][col] + calcu(row, col + 1));
        }
        return min[row][col];
    }

    //非递归方式
    public static int calcuNonRecursive(int row, int col) {
        for (int i = m.length - 2; i > -1; i--) {
            min[m.length - 1][i] = m[m.length - 1][i] + min[m.length - 1][i + 1];
        }
        for (int i = m.length - 2; i > -1; i--) {
            min[i][m.length - 1] = m[i][m.length - 1] + min[i + 1][m.length - 1];
        }
        for (int i = m.length - 2; i > -1; i--) {
            for (int j = m.length - 2; j > -1; j--) {
                min[i][j] = m[i][j] + Math.min(min[i + 1][j], min[i][j + 1]);
            }
        }
        return min[row][col];
    }

}
