package programmers.dfs.backtracking;

import java.util.Scanner;

/**
 * 백준 스타트와 링크 (DFS)
 *
 * 1. 백트래킹을 이용한 조합 만들기 (A팀 조합만 만들면 자연스레 B팀 조합 만들어짐)
 * 2. 한 팀의 정원인 N / 2에 LV 탐색이 도달하면 각 팀 능력치 계산
 * 3. 능력치 계산 후 결과 교체 반복
 */
public class StartAndLink {
    static int n;
    static int[] visited;
    static int[][] board;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[n];
        board = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.print(result);
    }

    private static void dfs(int index, int lv) {
        if(lv >= n / 2) {
            calc();
        } else {
            for(int i = index ; i < n ; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    dfs(i + 1, lv + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    private static void calc() {
        int aScore = 0;
        int bScore = 0;
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(visited[i] == 1 && visited[j] == 1){
                    aScore += board[i][j];
                } else if(visited[i] == 0 && visited[j] == 0) {
                    bScore += board[i][j];
                }
            }
        }

        int diff = Math.abs(aScore - bScore);
        result = Math.min(result, diff);
    }
}
