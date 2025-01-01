package greedy;

import java.util.Scanner;

/**
 * 그리디 알고리즘
 *
 * 결혼식
 *
 * 정렬 X
 *
 * 주어진 2차원 배열에 친구가 결혼식에 도착한 시간 나간시간
 * 한번에 결혼식 피로연장에 있는 친구의 최대 인원수
 */
public class Wedding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = new int[73];
        int[] e = new int[73];

        int n = sc.nextInt();
        int[][] friends = new int[n][2];
        for(int i = 0 ; i< n ; i++) {
            friends[i][0] = sc.nextInt();
            friends[i][1] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++) {
            s[friends[i][0]]++;
            e[friends[i][1]]++;
        }

        int cnt = 0;
        int answer = 0;
        for(int i = 0 ; i < s.length ; i++) {
            cnt += s[i];
            cnt -= e[i];
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
