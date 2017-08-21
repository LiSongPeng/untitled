/**
 *
 * 字符串子串求和问题
 *
 */
public class Q18 {
    public static void main(String[] args) {
        System.out.println(sum("A1-B-2C--24D2.6"));
    }

    public static int sum(String str) {
        int sum = 0;
        int currNum = 0;
        char curr;
        boolean sign = false;
        for (int i = 0; i < str.length(); i++) {
            curr = str.charAt(i);
            if (curr == '.'){
                sign=false;
                continue;
            }
            if (curr == '-') {
                sign = !sign;
                continue;
            }
            if (curr - '0' < 0 || curr - '0' > 9) {
                sign = false;
                continue;
            }
            while (curr - '0' > -1 && curr - '0' < 10) {
                currNum = currNum * 10 + curr-'0';
                if(i<str.length()-1)
                    curr = str.charAt(++i);
                else
                    break;
            }
            if (sign)
                currNum = -currNum;
            sum += currNum;
            currNum = 0;
            sign = false;
        }
        return sum;
    }
}