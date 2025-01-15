package programmers.dfs;

/**
 * DFS 섬의 개수 구하기 기초
 *
 * 동서남북 만
 */
public class Islands {

    public static void main(String[] args) {
        int[][] board = new int[7][7];
        board[0] = new int[]{1,1,0,0,0,1,0};
        board[1] = new int[]{0,1,1,0,1,1,0};
        board[2] = new int[]{0,1,0,0,0,0,0};
        board[3] = new int[]{0,0,0,1,0,1,1};
        board[4] = new int[]{1,1,0,1,1,0,0};
        board[5] = new int[]{1,0,0,0,1,0,0};
        board[6] = new int[]{1,0,1,0,1,0,0};

        int cnt = 0;
        for(int i = 0 ; i < 7 ; i++) {
            for(int j = 0 ; j < 7 ; j++) {
               if(board[i][j] == 1) {
                   DFS(board, j, i);
                   cnt++;
               }
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int[][] board, int x, int y) {
        if(x < 0 || y < 0 || x > board[0].length - 1 || y > board.length - 1 || board[y][x] == 0) {
            return;
        }
        board[y][x] = 0;
        DFS(board, x - 1 , y);
        DFS(board, x + 1 , y);
        DFS(board, x , y + 1);
        DFS(board, x , y - 1);
    }
}
