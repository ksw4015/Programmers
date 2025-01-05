package dp;


import java.util.Arrays;
import java.util.Scanner;

public class MaximumScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문제 수
        int m = sc.nextInt(); // 제한 시간

        int[][] p = new int[n][2];  // 문제 [점수, 시간]

        for(int i = 0 ; i < n ; i++) {
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
        }

        int[] dy = new int[m+1];
        Arrays.sort(p, (i1, i2) -> i2[0] - i1[0]); // 점수 내림차순 정렬

        for(int i = 0 ; i < p.length ; i++) {
            int time = p[i][1];
            int score = p[i][0];
            // 1. 문제는 유형별로 1번만 풀수 있어서 dy 뒤쪽부터 순회
            // 2. 해당 문제를 푸는데 가능한 시간까지만 순회
            for(int j = m ; j >= time ; j--) {
                dy[j] = Math.max(dy[j], score + dy[j-time]);
            }
        }

        System.out.println(dy[m]);
    }
}
