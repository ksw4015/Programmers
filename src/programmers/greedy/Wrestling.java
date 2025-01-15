package programmers.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 기초강의
 *
 * 씨름선수
 */
public class Wrestling {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[][] players = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            players[i][0] = in.nextInt();
            players[i][1] = in.nextInt();
        }

        int answer = 1;
        Arrays.sort(players, (o1, o2) -> {
            if(o2[0] == o1[0])
                return o2[1] - o1[1];
            return o2[0] - o1[0];
        });
        int max = players[0][1];

        for(int i = 1 ; i < players.length ; i++) {
            if(max <= players[i][1]) {
                answer++;
                max = Math.max(max, players[i][1]);
            }
        }

        System.out.println(answer);
    }
}
