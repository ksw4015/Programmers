package programmers.graph;

import java.util.*;

/**
 * 다익스트라 알고리즘
 *
 * 기본 강의
 *
 * 우선순위 큐 이용
 */
public class Dijkstra {
    public static void main(String[] args) {
        // 정점 개수
        int n = 6;
        // 정점 이동 정보 배열 (단방향)
        int[][] map = new int[][] {
                {1,2,12}, {1,3,4}, {2,1,2}, {2,3,5}, {2,5,5}, {3,4,5}, {4,2,2}, {4,5,5}, {6,4,5}
        };

        // 1. 정점 정보를 인접 리스트로 (Map도 되고 List도 됨)
        // K = 정점, V = {목적지, 비용}
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        for(int[] ver : map) {
            adjList.putIfAbsent(ver[0], new ArrayList<>());
            // 갈 수 있는 목적지, 비용 저장
            adjList.get(ver[0]).add(new int[]{ver[1], ver[2]});
        }

        // 각 정점까지 최소비용을 저장할 배열
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;  // 시작점 비용 초기화 (0 고정)

        // 비용이 적은 목적지부터 Poll하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{1, 0});  // 시작점 삽입
        while (!pq.isEmpty()) {
            // 목적지
            int[] curr = pq.poll();
            if(dis[curr[0]] < curr[1]) continue;
            if(adjList.containsKey(curr[0])) {
                for (int[] nv : adjList.get(curr[0])) {
                    if (dis[nv[0]] > nv[1] + curr[1]) {
                        dis[nv[0]] = nv[1] + curr[1];
                        pq.add(new int[]{nv[0], nv[1] + curr[1]});
                    }
                }
            }
        }

        for(int i = 2 ; i < dis.length ; i++) {
            if(dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
                continue;
            }
            System.out.println(i + " : " + dis[i]);
        }
    }
}
