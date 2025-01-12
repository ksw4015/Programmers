package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class FindAndSwitch {
    public int solution(String s, String t) {
        int count = 0;
        int tLength = t.length();
        char[] tChars = t.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            stack.addLast(c);
            // 스택의 마지막 부분이 t와 동일한지 확인
            if (stack.size() >= tLength) {
                boolean match = true;
                // 스택의 끝 부분과 t를 비교
                Iterator<Character> iterator = stack.descendingIterator();
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
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindAndSwitch T = new FindAndSwitch();
        System.out.println(T.solution("aabcbcd", "abc"));
        System.out.println(T.solution("aaaaabbbbb", "ab"));
    }
}
