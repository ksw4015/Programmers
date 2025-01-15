package programmers.dp;

import java.util.Scanner;

/**
 * 다이내믹 프로그래밍 기본
 *
 * 돌 다리 건너기
 *
 * 1칸 또는 2칸씩 이동 가능
 * 돌이 N개 있을때 강을 건너갈 수 있는 경우의 수 구하기
 */
public class StoneBridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] bridges = new int[n+2]; // 강을 건너기 까지
        bridges[0] = 1;
        bridges[1] = 1;
        for(int i = 2 ; i < bridges.length ; i++) {
            bridges[i] = bridges[i-1] + bridges[i-2];
        }

        System.out.println(bridges[n+1]);
    }
}
