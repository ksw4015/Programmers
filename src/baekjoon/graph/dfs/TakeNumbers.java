package baekjoon.graph.dfs;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 백준 숫자고르기
 * 완전탐색
 * DFS
 */
public class TakeNumbers {
    private static boolean[] chk;
    private static Set<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = sc.nextInt();
        }

        // 초기화
        set = new TreeSet<>();
        chk = new boolean[N+1];
        // DFS 시작
        for(int i = 1 ; i <= N ; i++) {
            chk[i] = true;
            dfs(i, i, arr);  // 처음 dfs는 시작지점 = 찾아야하는 숫자
            chk[i] = false;
        }

        System.out.println(set.size());
        for (int result : set) {
            System.out.println(result);
        }
    }

    /**
     * Target이 나올때까지 탐색하다가 Target이 찾아지면 카드집합에 넣는다.
     *
     * @param start 시작점
     * @param target 찾아야하는 숫자
     */
    private static void dfs(int start, int target, int[] arr) {
        int value = arr[start];
        if(!chk[value]) {  // 탐색 가능하면 탐색
            chk[value] = true;
            dfs(value, target, arr);  // 찾아야하는 숫자는 유지
            chk[value] = false;
        }

        if(value == target) {
            set.add(target);
        }
    }
}
