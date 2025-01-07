package stack;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 백준 쇠막대기
 *
 * 스택
 */
public class IronStick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int answer = 0;

        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));

        // 직전 입력 값 (Stack 최상단 X)
        char c = s.charAt(0);
        for(int i = 1 ; i < s.length() ; i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                    if (c == '(') {
                        answer += stack.size();
                    } else {
                        answer++;
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            c = s.charAt(i);
        }

        System.out.println(answer);
    }
}
