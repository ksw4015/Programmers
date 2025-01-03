package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DP 기본강의
 *
 * 계단 오르기
 *
 * N번째 계단까지 오를수 있는 모든 경우의 수 구하기
 *
 * 계단을 한 칸 또는 두 칸씩 올라갈 수 있다.
 */
public class UpStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] stairs = new int[n+1];
        stairs[0] = 1;
        stairs[1] = 1;
        for(int i = 2 ; i < stairs.length ; i++) {
            stairs[i] = stairs[i-1] + stairs[i-2];
        }
        System.out.println(stairs[n]);
    }
}
