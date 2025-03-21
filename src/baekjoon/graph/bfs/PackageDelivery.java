package baekjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 5972번
 *
 * 택배 배송
 *
 */
public class PackageDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 타겟 위치 (노드 개수)
        int N = Integer.parseInt(st.nextToken());
        // 노드 이동 비용
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            map.putIfAbsent(node, new ArrayList<>());
            map.get(node).add(new int[]{dest, price});
            map.putIfAbsent(dest, new ArrayList<>());
            map.get(dest).add(new int[]{node, price});
        }

        // 도착, 비용 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{1, 0});

        int[] result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(result[curr[0]] < curr[1])
                continue;

            // 갈 수 있는 곳 쳌
            if(map.containsKey(curr[0])) {
                for(int[] dest : map.get(curr[0])) {
                    int target = dest[0];
                    int price = dest[1] + curr[1];
                    if(result[target] > price) {
                        result[target] = price;
                        pq.offer(new int[]{target, price});
                    }
                }
            }
        }

        System.out.println(result[N]);
    }
}
