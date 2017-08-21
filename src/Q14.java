//KMP算法
public class Q14 {
    public static void main(String[] args) {
        System.out.println(kmp("adfasdfsabsdfsdssab".toCharArray(), "ssab".toCharArray()));
    }

    public static int kmp(char[] target, char[] pattern) {
        int[] next = new int[pattern.length];
        next[0] = 0;
        for (int i = 1, k = 0; i < pattern.length; i++) {
            while (k > 0 && pattern[i] != pattern[k])
                k = next[k - 1];
            if (pattern[i] == pattern[k])
                k++;
            next[i] = k;
        }
        int index = -1;
        for (int i = 0, p = 0; i < target.length; i++) {
            while (p > 0 && target[i] != pattern[p])
                p = next[p - 1];
            if (target[i] == pattern[p])
                p++;
            if (p == pattern.length) {
                index = i - pattern.length + 1;
                break;
            }
        }
        return index;
    }
}
