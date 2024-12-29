package array;

import java.util.*;

/**
 * 프로그래머스
 * 실패율
 */
public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] challengers = new int[N+1];
        for(int i = 0 ; i < stages.length ; i++) {
            challengers[stages[i]] += 1;
        }

        // K = 스테이지, V = 실패율
        HashMap<Integer, Double> result = new HashMap<>();
        // 소수점 계산을 위해 double 형으로 선언
        double total = stages.length;
        for(int i = 1 ; i <= N ; i++) {
            if(challengers[i] == 0) {
                result.put(i, 0.0);
            } else {
                result.put(i, challengers[i] / total);
                total -= challengers[i];
            }
        }

        return result.entrySet().stream().sorted((o1, o2) -> {
            if(Objects.equals(o1.getValue(), o2.getValue()))
                return Double.compare(o1.getKey(), o2.getKey());
            return Double.compare(o2.getValue(), o1.getValue());
        }).mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        FailureRate T = new FailureRate();
        System.out.println(
                Arrays.toString(T.solution(
                        3, new int[] {1,1,2,2}
                ))
        );
        System.out.println(
                Arrays.toString(T.solution(
                        5, new int[] {1,1,1,2,3,4}
                ))
        );
        System.out.println(
                Arrays.toString(T.solution(
                        5, new int[] {3,3,3,3,3}
                ))
        );
    }
}
