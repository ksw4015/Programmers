package baekjoon.simulation;

import java.util.Scanner;

/**
 * 백준 덩치 문제
 */
public class Size {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] men = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            men[i][0] = sc.nextInt();
            men[i][1] = sc.nextInt();
        }

        int[] answer = new int[n];
        // 브루트 포스
        for(int i = 0 ; i < men.length ; i++) {
            int k = 0;
            for(int j = 0 ; j < men.length ; j++) {
                if(i == j)
                    continue;
                if(men[i][0] < men[j][0] && men[i][1] < men[j][1])
                    k++;
            }
            answer[i] = k + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int a : answer) {
            sb.append(a);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
