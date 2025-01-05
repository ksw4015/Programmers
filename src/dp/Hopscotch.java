package dp;

import java.util.Arrays;

/**
 * 프로그래머스 땅다먹기
 *
 */
public class Hopscotch {
    private static int solution(int[][] land) {
        for(int i = 1 ; i < land.length ; i++) {
            land[i][0] = land[i][0] + Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] = land[i][1] + Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] = land[i][2] + Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] = land[i][3] + Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        int n = land.length-1;
        return Math.max(Math.max(land[n][0],land[n][1]), Math.max(land[n][2],land[n][3]));
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1,2,3,5}, {5,6,7,8}, {4,3,2,1}
        }));
    }
}
