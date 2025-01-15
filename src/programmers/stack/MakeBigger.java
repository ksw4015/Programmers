package programmers.stack;

import java.util.Scanner;
import java.util.Stack;

public class MakeBigger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int K = sc.nextInt();
        String number = sc.next();

        Stack<Character> stack = new Stack<>();
        int toRemove = K; // 제거해야 할 숫자 수

        // 숫자 순회
        for (int i = 0; i < N; i++) {
            char digit = number.charAt(i);

            // 스택의 맨 위 숫자가 현재 숫자보다 작고, 제거 가능하다면 제거
            while (!stack.isEmpty() && stack.peek() < digit && toRemove > 0) {
                stack.pop();
                toRemove--;
            }

            // 현재 숫자 추가
            stack.push(digit);
        }

        // 남은 숫자 처리 (필요 없는 뒤쪽 숫자 제거)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N - K; i++) {
            result.append(stack.get(i));
        }

        // 결과 출력
        System.out.println(result);
    }
}
