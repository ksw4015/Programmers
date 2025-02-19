package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2493
 * 탑
 *
 */
public class Tower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++) {
            int v = Integer.parseInt(st.nextToken());
            // 스택이 비어있지 않고, 현재 탑보다 낮은 탑은 필요 없으므로 제거
            while (!stack.isEmpty() && stack.peek()[1] < v) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek()[0]).append(" "); // 가장 가까운 큰 탑의 위치
            }
            stack.push(new int[]{i, v});
        }
        System.out.println(sb);
    }
}
