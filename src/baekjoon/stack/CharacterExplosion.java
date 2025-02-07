package baekjoon.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 백준
 * 문자열 폭발
 */
public class CharacterExplosion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String bomb = sc.next();
        char[] tChars = bomb.toCharArray();
        int tLength = tChars.length;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            stack.addLast(c);
            // 스택의 마지막 부분이 t와 동일한지 확인
            if (stack.size() >= tLength) {
                boolean match = true;
                // 스택의 끝 부분과 t를 비교
                Iterator<Character> iterator = stack.descendingIterator(); // 스택 역방향 순회
                for (int i = tLength - 1; i >= 0; i--) {
                    if (!iterator.next().equals(tChars[i])) {
                        match = false;
                        break;
                    }
                }

                // 일치하는 경우 제거
                if (match) {
                    for (int i = 0; i < tLength; i++) {
                        stack.removeLast();
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for(Character character : stack) {
                sb.append(character);
            }
            System.out.println(sb);
        }
    }
}
