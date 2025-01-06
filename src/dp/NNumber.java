package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 다이내믹 프로그래밍
 * 프로그래머스 N 으로 표현
 * (문제가 썩 좋은건 아닌거같음)
 *
 * GPT 풀이
 */
public class NNumber {
    public static int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        // 1~8 까지 N의 개수 HashSet
        for(int i = 0 ; i < 9 ; i++) {
            list.add(new HashSet<>()); // 0 ~ 8 까지 지만 사용은 1 ~ 8
        }

        for(int i = 1 ; i < 9 ; i++) {
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));  // N, NN, NNN ~ 로 초기화
        }

        for(int i = 1 ; i < 9 ; i++) {
            for(int j = 1 ; j < i ; j++) {  // i 이전 조합 모두 순회
                for(int num1 : list.get(j)) {
                    for(int num2 : list.get(i-j)) {
                        list.get(i).add(num1 + num2);
                        list.get(i).add(num1 - num2);
                        list.get(i).add(num1 * num2);
                        if(num2 != 0)
                            list.get(i).add(num1 / num2);
                    }
                }
            }
            if(list.get(i).contains(number))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }
}
