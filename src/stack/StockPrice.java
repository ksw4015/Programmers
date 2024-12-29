package stack;

import java.util.Arrays;

/**
 * 프로그래머스
 * 주식 가격
 *
 * 우선 브루트포스
 */
public class StockPrice {
    // 왜 풀림...
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length - 1 ; i++) {
            int time = 0;
            for(int j = i + 1 ; j < prices.length ; j++) {
                time++;
                if(prices[j] < prices[i])
                    break;
            }
            answer[i] = time;
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice T = new StockPrice();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 2, 3})));
    }
}
