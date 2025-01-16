package programmers.dfs;

import java.util.Scanner;

/**
 * 백준 알파벳
 *
 * DFS
 *
 */
public class Alphabet {
    static int[] chk = new int[26];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] board = new char[r][c];
        for(int i = 0 ; i < board.length ; i++) {
            String s = sc.next();
            board[i] = s.toCharArray();
        }

        dfs(board, 0, 0, 0);
        System.out.print(count);
    }

    private static void dfs(char[][] board, int x, int y, int sum) {
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || chk[board[x][y] - 'A'] == 1) {
            count = Math.max(count, sum);
            return;
        }
        chk[board[x][y] - 'A'] = 1;
        dfs(board, x, y + 1, sum + 1); // 동
        dfs(board, x, y - 1, sum + 1); // 서
        dfs(board, x + 1, y, sum + 1); // 남
        dfs(board, x - 1, y, sum + 1); // 북
        chk[board[x][y] - 'A'] = 0;
    }
}
