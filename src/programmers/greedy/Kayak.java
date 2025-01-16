package programmers.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 카약과 강풍 2891
 *
 */
public class Kayak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();  // 카약이 부서진 팀 수
        int l = sc.nextInt();  // 카약을 하나더 가져온 팀 수

        int[] teams = new int[n];
        for(int i = 0 ; i < k ; i++) {
            int index = sc.nextInt();
            teams[index-1] = -1;
        }
        for(int i = 0 ; i < l ; i++) {
            int index = sc.nextInt();
            teams[index-1]++;
        }

        for(int i = 0 ; i < teams.length ; i++) {
            if(teams[i] == 1) {
                if(i != 0 && teams[i-1] == -1) {
                    teams[i-1] = 0;
                } else if(i != teams.length - 1 && teams[i+1] == -1) {
                    teams[i+1] = 0;
                }
            }
        }

        int count = 0;
        for(int t : teams) {
            if(t == -1)
                count++;
        }

        System.out.print(count);
    }
}
