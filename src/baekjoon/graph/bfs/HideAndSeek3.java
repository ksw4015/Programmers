package baekjoon.graph.bfs;

import java.util.*;

/**
 * 백준 숨바꼭질3
 *
 */
public class HideAndSeek3 {
    public static void main(String[] args) {
        int MAX = 100000;

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();  // 수빈이 시작위치
        int target = sc.nextInt();  // 동생 위치

        Deque<int[]> deque = new ArrayDeque<>();
        int[] time = new int[MAX + 1];
        Arrays.fill(time, Integer.MAX_VALUE); // 초기값을 최대값으로 설정
        time[start] = 0;

        deque.addFirst(new int[]{start, 0}); // (현재 위치, 소요 시간)

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int pos = current[0];
            int cost = current[1];

            // 도착하면 종료
            if (pos == target) {
                System.out.println(cost);
                return;
            }

            // 순간이동 (0초)
            if (pos * 2 <= MAX && cost < time[pos * 2]) {
                time[pos * 2] = cost;
                deque.addFirst(new int[]{pos * 2, cost});
            }
            // 앞으로 이동 (1초)
            if (pos + 1 <= MAX && cost + 1 < time[pos + 1]) {
                time[pos + 1] = cost + 1;
                deque.addLast(new int[]{pos + 1, cost + 1});
            }
            // 뒤로 이동 (1초)
            if (pos - 1 >= 0 && cost + 1 < time[pos - 1]) {
                time[pos - 1] = cost + 1;
                deque.addLast(new int[]{pos - 1, cost + 1});
            }
        }
    }
}
