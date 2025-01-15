package programmers.dfs.backtracking;

/**
 * 프로그래머스
 * N 퀸
 * n x n 격자판에 n개의 퀸을 놓을수 있는 조합
 *
 * 백트래킹
 */
public class NQueen {
    static int answer = 0;
    static boolean[] queens;
    static boolean[] chk1;
    static boolean[] chk2;

    public int solution(int n) {
        queens = new boolean[n];
        chk1 = new boolean[n*2];
        chk2 = new boolean[n*2];
        dfs(0, n);
        return answer;
    }

    // x 는 행
    private void dfs(int x, int n) {
        if(x == n) {
            answer++;
        } else {
            // 열 반복
            for(int y = 0 ; y < n ; y++) {
                if(queens[y] || chk1[x+y] || chk2[y - x + n])
                    continue;
                queens[y] = true;
                chk1[x+y] = true;
                chk2[y-x+n] = true;
                dfs(x+1, n);
                queens[y] = false;
                chk1[x+y] = false;
                chk2[y-x+n] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueen T = new NQueen();
        System.out.println(T.solution(4));
    }
}
