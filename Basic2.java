import java.io.*;
import java.util.*;

public class Main {
    public static int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack stack = new Stack();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i: stack) {
            re += i;
        }
        return re;
    }

    public static void main(String[] args) throws Exception {
        int result = calculate("-3+3+2*2+8/2");
        System.out.println(result);

    }
}
