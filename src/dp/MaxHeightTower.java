package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 다이내믹 프로그래밍
 * 가장 높은 탑 쌓기
 *
 * 배열에 너비, 높이, 무게 순으로 주어짐
 * 너비나 무게가 높은거에서 낮은 순으로 쌓을수 있음
 *
 * 너비, 무게는 전부 다름
 */
public class MaxHeightTower {
    public static void solution(int[][] tower) {
        // 너비로 내림차순 정렬
        Arrays.sort(tower, (o1, o2) -> o2[0] - o1[0]);

        // 주어진 벽돌까지 쌓을 수 있는 최대 높이 저장
        int[] dy = new int[tower.length];
        dy[0] = tower[0][1];  // 가장 넓은 벽돌

        // 지금까지 쌓은 탑중 제일 높은 높이
        int answer = 0;
        for(int i = 1 ; i < dy.length ; i++) {
            int max = 0;
            for(int j = i - 1 ; j >= 0 ; j--) {
                if(tower[j][2] > tower[i][2]) {  // 쌓을 수 있으면 Max값 교체
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = max + tower[i][1];
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] stone = new int[n][3];
        for(int i = 0 ; i < n ; i++) {
            stone[i][0] = sc.nextInt();
            stone[i][1] = sc.nextInt();
            stone[i][2] = sc.nextInt();
        }

        solution(stone);
    }
}
