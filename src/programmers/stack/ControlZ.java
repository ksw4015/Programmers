package programmers.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 프로그래머스
 * 컨트롤 제트
 */
public class ControlZ {
    public int solution(String s) {
        int answer = 0;

        String[] arr = s.split(" ");
        Deque<String> stack = new ArrayDeque<>();

        answer += Integer.valueOf(arr[0]);
        stack.push(arr[0]);
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i].equals("Z")) {
                answer -= Integer.valueOf(stack.peek());
            } else {
                answer += Integer.valueOf(arr[i]);
                stack.push(arr[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ControlZ T = new ControlZ();
        System.out.println(T.solution("1 2 Z 3"));
        System.out.println(T.solution("10 20 30 40"));
        System.out.println(T.solution("10 Z 20 Z 1"));
        System.out.println(T.solution("10 Z 20 Z"));
        System.out.println(T.solution("-1 -2 -3 Z"));
    }
}
