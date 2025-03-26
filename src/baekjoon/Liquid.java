package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2467번 용액
 */
public class Liquid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 용액 개수
        String[] input = br.readLine().split(" ");

        int[] liquid = new int[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(input[i]);
        }

        int lp = 0;
        int rp = N - 1;
        int minVal = liquid[lp];
        int maxVal = liquid[rp];
        int minDiff = Math.abs(minVal + maxVal); // 초기값 설정

        while (lp < rp) {
            int sum = liquid[lp] + liquid[rp];

            // 0에 더 가까운 조합이면 갱신
            if (Math.abs(sum) < minDiff) {
                minDiff = Math.abs(sum);
                minVal = liquid[lp];
                maxVal = liquid[rp];
            }

            // 투 포인터 이동
            if (sum > 0) {
                rp--;  // 합이 양수면 오른쪽 값을 줄여야 함
            } else {
                lp++;  // 합이 음수면 왼쪽 값을 증가시켜야 함
            }
        }

        System.out.println(minVal + " " + maxVal);
    }
}
