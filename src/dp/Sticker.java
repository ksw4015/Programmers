package dp;

import java.util.Arrays;

/**
 * 프로그래머스 스티커
 *
 * 일단 도둑질과 유사한 DP 문제같아서 가져옴
 */
public class Sticker {
    public static int solution(int[] sticker) {
        // 첫번째 스티커 사용 (마지막 스티커 사용 안함)
        int[] dy1 = new int[sticker.length]; // 가장 큰 점수 저장
        dy1[0] = sticker[0];
        dy1[1] = Math.max(sticker[0], sticker[1]);
        for(int i = 2 ; i < sticker.length - 1 ; i++) {
            dy1[i] = Math.max(dy1[i-2]+sticker[i], dy1[i-1]);
        }

        // 마지막 스티커 사용 (첫번째 스티커 0)
        int[] dy2 = new int[sticker.length];
        dy2[0] = 0;
        dy2[1] = sticker[1];
        for(int i = 2 ; i < sticker.length ; i++) {
            dy2[i] = Math.max(dy2[i-2]+sticker[i], dy2[i-1]);
        }
        return Math.max(dy1[dy1.length-2], dy2[dy2.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,2,5,4}));
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
    }
}
