package simulation;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int index;
        int move = len-1;

        char[] nameChar = name.toCharArray();
        for (int i = 0 ; i < nameChar.length ; i++) {
            int diff = Math.min(nameChar[i] - 'A', 'Z' - nameChar[i] + 1);
            answer += diff; // A가 아닌 문자의 최소 이동횟수 먼저 더하기

            // 탐색중에 계속 연속된 A의 길이를 체크
            index = i + 1;
            while(index < len && name.charAt(index) == 'A'){
                index++;
            }

//            move = Math.min(move, Math.min(i + len - index + i, i + len - index + len - index));
//            move = Math.min(move, Math.min(index, len-index));
            move = Math.min(move, Math.min(i + len - index + i, i + len - index + len - index));
        }

        return answer+move;
    }

    public static void main(String[] args) {
        JoyStick T = new JoyStick();
        System.out.println(T.solution("JAZ"));
        System.out.println(T.solution("JEROEN"));
        System.out.println(T.solution("JAN"));
    }
}
