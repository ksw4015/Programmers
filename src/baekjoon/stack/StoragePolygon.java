package baekjoon.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 창고 다각형
 *
 */
public class StoragePolygon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] stick = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            stick[i][0] = sc.nextInt();
            stick[i][1] = sc.nextInt();
        }

        Arrays.sort(stick, Comparator.comparingInt(o -> o[0]));

        int result = 0;

        // 최고 기둥
        int[] highest = new int[2];
        Stack<int[]> stack = new Stack<>();

        // 높이가 같을때도 더해야 할까?

        // 왼쪽 -> 오른쪽 순회
        // 스택에 있는 기둥보다 현재 기둥이 큰 경우에만 면적 계산 후 스택 pop -> 현재 기둥 push
        // 매번 최고기둥 체크 후 교체
        for(int i = 0 ; i < n ; i++) {
            if(!stack.isEmpty()) {
                if(stack.peek()[1] <= stick[i][1]) {
                    int[] prev = stack.pop();
                    result += (stick[i][0] - prev[0]) * prev[1];
                    stack.push(stick[i]);
                }
            } else {
                stack.push(stick[i]);
            }
            if(highest[1] < stick[i][1]) {
                highest = stick[i];
            }
        }

        stack.clear();
        // 오른쪽 -> 왼쪽 순회 but 최고기둥 x좌표 전까지
        // 스택에 있는 기둥보다 현재 기둥이 큰 경우에만 면적 계산 후 스택 pop -> 현재 기둥 push
        for(int i = n - 1 ; i >= 0 ; i--) {
            if(stick[i][0] >= highest[0]) {
                if (!stack.isEmpty()) {
                    if (stack.peek()[1] < stick[i][1]) {
                        int[] prev = stack.pop();
                        result += (prev[0] - stick[i][0]) * prev[1];
                        stack.push(stick[i]);
                    }
                } else {
                    stack.push(stick[i]);
                }
            }
        }

        // 순회 완료 후 최고기둥 높이 그대로 더함
        result += highest[1];
        System.out.println(result);
    }
}
