import java.io.*;
import java.util.*;

public class Main {

    public static int calculate(String s) {
        int sum = 0;
        int sign = 1;
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val = val * sign;
                sign = 1;
                sum += val;

            } else if (ch == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum *= stack.pop();
                sum += stack.pop();
            } else if (ch == '-') {
                sign *= -1;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
    
        int result = calculate("222+2+(2+2)");
        System.out.println(result);

    }
}
