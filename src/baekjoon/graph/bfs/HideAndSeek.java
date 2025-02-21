package baekjoon.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 숨바꼭질1
 *
 */
public class HideAndSeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] visited = new int[100001];
        visited[n] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int lv = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                int curr = queue.poll();
                if(curr == k) {
                    System.out.println(lv);
                    return;
                }

                int right = curr + 1;
                int left = curr - 1;
                int jump = curr * 2;
                int[] arr = {right, left, jump};
                for(int j : arr) {
                    if(available(j) && visited[j] == 0) {
                        visited[j] = 1;
                        queue.add(j);
                    }
                }
            }
            lv++;
        }
    }

    private static boolean available(int n) {
        return n >= 0 && n <= 100000;
    }
}
