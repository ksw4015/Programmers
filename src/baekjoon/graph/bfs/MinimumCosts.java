package baekjoon.graph.bfs;

import java.util.*;

/**
 * 백준 최소비용 구하기
 * 1916 번
 */
public class MinimumCosts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0 ; i < m ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            map.putIfAbsent(start, new ArrayList<>()); // 출발지
            map.get(start).add(new int[]{end, cost});  // 도착지, 비용
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});  // 출발지, 비용 = 0
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(dist[curr[0]] < curr[1])
                continue;
            if(map.containsKey(curr[0])) {
                for(int[] dest : map.get(curr[0])) {
                    int nC = dest[1] + curr[1]; // 목적지로 가는 비용
                    if(dist[dest[0]] > nC) { // 목적지까지 가는 기존 비용이 새로운 비용보다 크면 교체
                        dist[dest[0]] = nC;
                        pq.add(new int[]{dest[0], nC});
                    }
                }
            }
        }

        System.out.println(dist[end]);
    }
}
