package simulation;

import java.util.Arrays;

/**
 * 구현 강의 문제
 *
 * 청소
 *
 */
public class Cleaner {
    // 이동에 1초, 회전에 1초
    // 벽 or 장애물 도달시 90도로 회전 (동 -> 남 -> 서 -> 북)
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int dir = 0;

    public static int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        dir = 0;
        for(int i = 0 ; i < k ; i++) {
            int nx = answer[1] + dx[dir];
            int ny = answer[0] + dy[dir];
            if(dir == 0 && (nx >= board[0].length || board[ny][nx] == 1)) {
                dir = 1;
            } else if(dir == 1 && (ny >= board.length || board[ny][nx] == 1)) {
                dir = 2;
            } else if(dir == 2 && (nx < 0 || board[ny][nx] == 1)) {
                dir = 3;
            } else if(dir == 3 && (ny < 0 || board[ny][nx] == 1)) {
                dir = 0;
            } else {
                answer[0] = ny;
                answer[1] = nx;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr3, 25)));
    }
}
