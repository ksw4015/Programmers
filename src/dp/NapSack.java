package dp;

import java.util.Scanner;

/**
 * 다이내믹 프로그래밍
 * 동전 교환 알고리듬
 *
 * 냅색알고리듬
 *
 */
public class NapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 동전 개수
        int[] coins = new int[n];
        for(int i = 0 ; i < n ; i++) {
            coins[i] = sc.nextInt();
        }

        int k = sc.nextInt();  // 거슬러줄 돈
        int[] dy = new int[k+1];

        // 동전 순회
        for (int coin : coins) {
            // 각 동전으로 거슬러 줄 수 있는 최소 동전 개수 저장
            for (int j = 1; j < dy.length; j++) {
                if(dy[j] == 0) {
                    dy[j] = j / coin + dy[j % coin];
                } else {
                    dy[j] = Math.min(dy[j], j / coin + dy[j % coin]);
                }
            }
        }

        System.out.println(dy[k]);
    }
}
