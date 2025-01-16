package programmers.dfs;

import java.util.*;

/**
 * 백준 영역 구하기
 */
public class CalcArea {
    static int land = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로
        int[][] board = new int[n][m];

        int k = sc.nextInt();
        int[][] w = new int[k][4];
        for(int i = 0 ; i < k ; i++) {
            w[i][0] = sc.nextInt();  // 왼쪽 X
            w[i][1] = sc.nextInt();  // 왼족 Y
            w[i][2] = sc.nextInt();
            w[i][3] = sc.nextInt();
        }

        for(int i = 0 ; i < w.length ; i++) {
            for(int a = w[i][1] ; a < w[i][3] ; a++) {
                for(int b = w[i][0] ; b < w[i][2] ; b++) {
                    board[a][b] = 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                if(board[i][j] == 0) {
                    land = 0;
                    dfs(board, i, j);
                    count++;
                    result.add(land);
                }
            }
        }

        Collections.sort(result);
        System.out.println(count);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    private static void dfs(int[][] board, int x, int y) {
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] == 1) {
            return;
        }
        land++;
        board[x][y] = 1;

        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
    }
}
