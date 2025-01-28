package programmers.graph;

import java.util.*;

/**
 * 환승 횟수가 정해져 있으면, 우선순위 큐를 사용할 수 없다!
 */
public class MinimumCosts {
    /**
     *
     * @param n 도시 개수
     * @param flights 비행 정보
     * @param s 출발지
     * @param e 목적지
     * @param k 환승횟수
     * @return
     */
    public int solution(int n, int[][] flights, int s, int e, int k){
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] f : flights) {
            adj.putIfAbsent(f[0], new ArrayList<>());
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] dir = new int[n];
        Arrays.fill(dir, Integer.MAX_VALUE);
        dir[s] = 0;

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{s, 0});

        int lv = 0;
        while (!pq.isEmpty()) {
            int len = pq.size();
            for(int i = 0 ; i < len ; i++) {
                int[] curr = pq.poll();
                if(adj.containsKey(curr[0])) {
                    for(int[] vertex : adj.get(curr[0])) {
                        if(dir[vertex[0]] > curr[1] + vertex[1]) {
                            dir[vertex[0]] = curr[1] + vertex[1];
                            pq.add(new int[]{vertex[0], dir[vertex[0]]});
                        }
                    }
                }
            }
            lv++;
            if(lv > k)
                break;
        }
        if(dir[e] == Integer.MAX_VALUE)
            return -1;
        return dir[e];
    }

    public static void main(String[] args){
        MinimumCosts T = new MinimumCosts();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
