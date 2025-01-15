package programmers.bfs;

import java.util.*;

/**
 * 프로그래머스
 *
 * 배달
 */
public class Delivery {

    // road[i][0] = 출발 노드, road[i][1] = 목적지, road[i][2] = 가중치
    public int solution(int N, int[][] road, int K) {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int[] r : road) {
            map.putIfAbsent(r[0], new ArrayList<>());
            map.putIfAbsent(r[1], new ArrayList<>());
            map.get(r[0]).add(new int[]{r[1], r[2]});
            map.get(r[1]).add(new int[]{r[0], r[2]});
        }

        // 각 노드별 최단 시간 저장
        int[] visited = new int[N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(visited[curr[0]] < curr[1])
                continue;
            if(map.containsKey(curr[0])) {
                for(int[] dest : map.get(curr[0])) {
                    // 더 오래걸리면 안감
                    if(visited[dest[0]] > curr[1] + dest[1]) {
                        visited[dest[0]] = curr[1] + dest[1];
                        pq.add(new int[]{dest[0], curr[1] + dest[1]});
                    }
                }
            }
        }

        int result = 0;
        for(int i = 1 ; i < visited.length ; i++) {
            if(visited[i] <= K)
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Delivery T = new Delivery();
        System.out.println(T.solution(5, new int[][]{
                {1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}
        }, 3));
        System.out.println(T.solution(6, new int[][]{
                {1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}
        }, 4));
    }
}
