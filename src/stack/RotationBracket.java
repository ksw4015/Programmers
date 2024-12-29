package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 프로그래머스
 * 괄호 회전하기
 *
 * (), {}, []
 */
public class RotationBracket {
    public int solution(String s) {
        if(s.length() % 2 == 1)
            return 0;

        StringBuilder sb = new StringBuilder(s);
        int answer = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(i != 0) {
                char pop = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(pop);
            }

            boolean success = true;
            Deque<Character> stack = new ArrayDeque<>();
            for(int j = 0 ; j < s.length() ; j++) {
                char ss = sb.charAt(j);
                if(stack.isEmpty()) {
                    if(ss == ')' || ss == '}' || ss == ']') {
                        success = false;
                        break;
                    }
                }
                if(ss == '(' || ss == '{' || ss == '[') {
                    stack.push(ss);
                } else {
                    char pop = stack.pop();
                    if((ss == ')' && pop != '(') || (ss == '}' && pop != '{') || (ss == ']' && pop != '[')) {
                        success = false;
                        break;
                    }
                }
            }
            if(success) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RotationBracket T = new RotationBracket();
        System.out.println(T.solution("[](){}"));
        System.out.println(T.solution("}]()[{"));
        System.out.println(T.solution("[)(]"));
        System.out.println(T.solution("}}}"));
        System.out.println(T.solution(")(}{"));
    }
}
