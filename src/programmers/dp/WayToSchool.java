package programmers.dp;

public class WayToSchool {
    public static int solution(int m, int n, int[][] puddles) {
        // m가로, n세로
        int[][] dy = new int[n][m];
        // puddles의 좌표도 가로, 세로로 유추
        for(int[] p : puddles) {
            dy[p[1]-1][p[0]-1] = -1;
        }

        // 시작점은 왜 1인지
        dy[0][0] = 1;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(dy[i][j] == -1)
                    continue;
                // 위에서
                if(i - 1 >= 0 && dy[i-1][j] != -1)
                    dy[i][j] += dy[i-1][j];
                // 왼쪽에서
                if(j - 1 >= 0 && dy[i][j-1] != -1)
                    dy[i][j] += dy[i][j-1];
                dy[i][j] %= 1_000_000_007;
            }
        }

        return dy[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2,2}}));
    }
}
