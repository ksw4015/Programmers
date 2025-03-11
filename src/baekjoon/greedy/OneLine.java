package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1138 번
 *
 * 한 줄로 서기
 *
 */
public class OneLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] line = new int[N];
        int[] result = new int[N];

        for(int i = 0 ; i < N ; i++) {
            line[i] = sc.nextInt();
        }

        for(int i = 0 ; i < N ; i++) {
            int count = 0;
            for(int j = 0 ; j < N ; j++) {
                if(count == line[i] && result[j] == 0) {
                    result[j] = i + 1;
                    break;
                }
                if(result[j] == 0) {
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r : result) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}
