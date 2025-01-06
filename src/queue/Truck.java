package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 프로그래머스 알고리즘 고득점 Kit
 *
 * 스택/큐
 * 다리를 지나는 트럭
 *
 */
public class Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> wq = new ArrayDeque<>(); // 대기 큐
        Queue<int[]> q = new ArrayDeque<>(); // 다리 큐

        for(int t : truck_weights) {
            wq.add(t);
        }

        while (!wq.isEmpty()) {
            answer++;
            if(q.isEmpty()) {
                q.add(new int[]{wq.poll(), 1});
            } else {
                // 나감과 동시에 들어올 수 있다.
                int len = q.size();
                // 현재 다리에 있는 트럭에 1초씩 더해준다
                // 1초를 더했을때 다리를 완전히 지나는 경우면 다리큐에서 제거한다.
                for(int i = 0 ; i < len ; i++) {
                    int[] t = q.poll();
                    t[1] += 1;
                    if(t[1] <= bridge_length) {
                        q.add(t);
                    }
                }

                // 현재 다리를 건너는 트럭들의 무게를 구한다
                int sum = 0;
                for(int[] t : q) {
                    sum += t[0];
                }
                // 대기하고 있는 트럭의 무게와 현재 다리를 지나는 트럭들의 무게 합과 더해서 무게제한보다 낮으면 다리큐에 대기트럭을 올린다.
                int wt = wq.peek();
                if(sum + wt <= weight) {
                    q.add(new int[]{wq.poll(), 1});
                }
            }
        }

        // 다리 큐를 다 비울때 까지 answer 증가 처리 빠짐
        while (!q.isEmpty()) {
            answer++;
            int len = q.size();
            for(int i = 0 ; i < len ; i++) {
                int[] t = q.poll();
                t[1] += 1;
                if(t[1] <= bridge_length) {
                    q.add(t);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                2, 10, new int[]{7,4,5,6}
        ));
        System.out.println(solution(
                100, 100, new int[]{10}
        ));
        System.out.println(solution(
                100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}
        ));
    }
}
