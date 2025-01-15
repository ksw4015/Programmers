package programmers.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] meetings = new int[n][2];

        for(int i = 0 ; i < n ; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        Arrays.sort(meetings, (i1, i2) -> {
            if(i1[1] == i2[1])
                return i1[0] - i2[0];
            return i1[1] - i2[1];
        });

        int answer = 1;
        int endTime = meetings[0][1];
        for(int i = 1 ; i < n ; i++) {
            if(meetings[i][0] >= endTime) {
                answer++;
                endTime = meetings[i][1];
            }
        }

        System.out.println(answer);
    }
}
