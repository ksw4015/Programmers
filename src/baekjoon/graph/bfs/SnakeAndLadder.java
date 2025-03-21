package baekjoon.graph.bfs;

import java.util.*;

/**
 * 백준 16928
 * 뱀과 사다리 게임
 */
public class SnakeAndLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사다리 (1 <= N <= 15개)
        int N = sc.nextInt();
        // 뱀 (1 <= N <= 15개)
        int M = sc.nextInt();

        Map<Integer, Integer> ladders = new HashMap<>();
        Map<Integer, Integer> snakes = new HashMap<>();

        for(int i = 0 ; i < N ; i++) {
            int start = sc.nextInt();
            int target = sc.nextInt();
            ladders.put(start, target);
        }
        for(int i = 0 ; i < M ; i++) {
            int start = sc.nextInt();
            int target = sc.nextInt();
            snakes.put(start, target);
        }

        int[] visited = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);  // 시작점 삽입
        visited[1] = 1;

        int lv = 0;
        while (!queue.isEmpty()) {
            lv++;
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                int curr = queue.poll();
                for(int j = 1 ; j <= 6 ; j++) {
                    int position = curr + j;
                    if(ladders.containsKey(position)) {
                        position = ladders.get(position);
                    } else if(snakes.containsKey(position)) {
                        position = snakes.get(position);
                    }
                    if(visited[position] == 0) {
                        visited[position] = 1;
                        queue.add(position);
                    }
                    if(position == 100) {
                        System.out.println(lv);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
