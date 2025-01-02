package greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeMaxNumber {
    public String solution(String number, int k) {
        int len = number.length();
        Deque<Character> answer = new ArrayDeque<>();
        for(int i = 0; i < len; i++) {
            char cur = number.charAt(i);
            while(!answer.isEmpty() && answer.peek() < cur && k > 0) {
                k--;
                answer.pop();
            }
            answer.push(cur);
        }

        StringBuilder result = new StringBuilder();
        while (!answer.isEmpty()) {
            result.append(answer.pop());
        }
        if (k > 0) {
            return result.reverse().substring(0, result.toString().length() - k);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        MakeMaxNumber T = new MakeMaxNumber();
        System.out.println(T.solution("1924", 2));
        System.out.println(T.solution("1231234", 3));
        System.out.println(T.solution("4177252841", 4));
    }
}
