package programmers.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 스프링쿨러 (그리디 강의 문제)
 *
 * 모든 꽃에 물을 주기위한 최소한의 스프링쿨러 개수 구하기
 */
public class SpringCooler {

    /**
     * @param n 스플링쿨러 개수 = n + 1
     * @param nums 각 스프링쿨러의 범위
     * @return 최소한의 스프링쿨러 개수
     */
    public int solution(int n, int[] nums){
        int answer = 0;

        // 1. nums를 순회하면서 각 스프링쿨러가 뿌릴 수 있는 왼쪽끝과 오른쪽 끝을 배열로 만들어서 저장
        // [[start, end], [start, end], [start, end] ...]
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) {
            int start = Math.max(0, i - nums[i]);
            int end = i + nums[i];
            list.add(new int[]{start, end});
        }

        // 2. 위에서 만든 배열을 start 값을 기준으로 오름차순 정렬
        list.sort(Comparator.comparingInt(o -> o[0]));

        // 현재 선택된 스프링쿨러로 뿌릴 수 있는 범위
        int start = 0;
        int end = 0;
        int i = 0;

        while (i < list.size()) {
            while (i < list.size() && list.get(i)[0] <= start) {
                end = Math.max(end, list.get(i)[1]); // start 지점이 커버 가능하면 더 좋은 쿨러의 end 범위로 계속 변경
                i++;
            }
            // 이전 start가 커버되지 않으면 1개 추가
            answer++;
            if(end == n) // 끝까지 다 뿌릴 수 있으면 결과 리턴
                return answer;
            if(start == end) // 중간에 못뿌리면 -1 리턴
                return -1;
            start = end; // 새로 뿌리기 시작한곳중 제일 큰 값으로 교체
        }

        return answer;
    }

    public static void main(String[] args){
        SpringCooler T = new SpringCooler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
