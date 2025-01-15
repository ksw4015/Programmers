package programmers.greedy;

import java.util.*;

/**
 * 그리디
 *
 * 우선순위 큐와 정렬 활용
 * 최대 수입 스케쥴
 */
public class MaxIncomeSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int income = sc.nextInt();
            int day = sc.nextInt();
            list.add(new int[]{income, day});
        }

        // 기한 내림차순 정렬
        list.sort((o1, o2) -> o2[1] - o1[1]);
        // 기한이 가장 긴 날 저장
        int maxDay = list.get(0)[1];
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for(int i = maxDay ; i > 0 ; i--) {
            for(;j < list.size() ; j++) {
                if(list.get(j)[1] < i)
                    break;
                pq.add(list.get(j)[0]);
            }
            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
