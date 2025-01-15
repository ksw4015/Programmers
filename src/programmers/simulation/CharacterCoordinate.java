package programmers.simulation;

import java.util.Arrays;

/**
 * 프로그래머스
 *
 */
public class CharacterCoordinate {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        int x = board[0] / 2;
        int y = board[1] / 2;
        for(int i = 0 ; i < keyinput.length ; i++) {
            if(keyinput[i].equals("left")) {
                if(answer[0] > -x) {
                    answer[0]--;
                }
            } else if(keyinput[i].equals("right")) {
                if(answer[0] < x) {
                    answer[0]++;
                }
            } else if(keyinput[i].equals("up")) {
                if(answer[1] < y) {
                    answer[1]++;
                }
            } else {
                if(answer[1] > -y) {
                    answer[1]--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CharacterCoordinate T = new CharacterCoordinate();
        System.out.println(Arrays.toString(T.solution(
                new String[]{"left", "right", "up", "right", "right"},
                new int[]{11, 11}
        )));
        System.out.println(Arrays.toString(T.solution(
                new String[]{"down", "down", "down", "down", "down"},
                new int[]{7, 9}
        )));
    }
}
