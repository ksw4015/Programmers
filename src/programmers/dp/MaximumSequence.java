package programmers.dp;

import java.util.Scanner;

/**
 * 다이내믹 프로그래밍 기본강의
 *
 * 최대 부분 증가수열
 *
 * 주어진 수열에서 연속으로 증가하는 수열을 만들때 제일 긴 수열의 길이
 */
public class MaximumSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int[] result = new int[arr.length];
        result[0] = 1;
        for(int i = 1 ; i < arr.length ; i++) {
            int max = 0; //  i - 1 부터 0까지 중 가장 긴 수열의 길이
            for(int j = i - 1 ; j >= 0 ; j--) {
                if(arr[j] < arr[i]) {
                    max = Math.max(max, result[j]);
                }
            }
            result[i] = max + 1;
            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer);
    }
}
