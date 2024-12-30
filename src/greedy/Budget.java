package greedy;

import java.util.Arrays;

/**
 * 프로그래머스
 *
 * 예산 (그리디)
 */
public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int remain = budget;

        Arrays.sort(d);
        for(int i = 0 ; i < d.length ; i++) {
            if(remain - d[i] >= 0) {
                remain -= d[i];
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Budget T = new Budget();
        System.out.println(T.solution(new int[]{1,3,2,5,4}, 9));
        System.out.println(T.solution(new int[]{2,2,3,3}, 10));
    }
}
