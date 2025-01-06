package simulation;

import java.util.Arrays;

/**
 * 구현 강의 문제
 *
 * 사다리 타기
 */
public class LadderGame {
    public static char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        for(int i = 0 ; i < n ; i++) {
            int start = i;
            for(int j = 0 ; j < ladder.length ; j++) {
                for(int k = 0 ; k < ladder[j].length ; k++) {
                    // 오른쪽이동
                    if(start == ladder[j][k] - 1) {
                        start++;
                        break;
                    } else if(ladder[j][k] == start) { // 왼쪽이동
                        start--;
                        break;
                    }
                }
            }
            answer[start] = (char)('A' + i);
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
