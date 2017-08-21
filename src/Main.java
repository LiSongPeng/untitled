public class Main {

    static int[][] matrix = {
            {7, 0, 0, 0, 0},
            {3, 8, 0, 0, 0},
            {8, 1, 0, 0, 0},
            {2, 7, 4, 4, 0},
            {4, 5, 2, 6, 5}
    };
    static int[][] maxRoute = new int[5][5];

    public static void main(String[] args) {
    }

    public static int maxRange(int x, int y) {
        if (x == 4)
            return maxRoute[x][y];
        if (maxRoute[x][y] != 0)
            return maxRoute[x][y];
        maxRoute[x][y] = matrix[x][y] + Math.max(maxRange(x + 1, y), maxRange(x + 1, y + 1));
        return maxRoute[x][y];
    }
}
