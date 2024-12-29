package dfs;

/**
 * 프로그래머스
 *
 * 네트워크
 */
public class Network {
    static int[] chk;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        chk = new int[computers.length];

        for(int i = 0 ; i < computers.length ; i++) {
            if(chk[i] == 0) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int now, int[][] computers) {
        chk[now] = 1;
        for(int i = 0 ; i < chk.length ; i++) {
            if(computers[now][i] == 1 && chk[i] != 1) {
                dfs(i, computers);
            }
        }
    }

    public static void main(String[] args) {
        Network T = new Network();
        System.out.println(T.solution(3, new int[][]{
                {1,1,0}, {1,1,0}, {0,0,1}
        }));
        System.out.println(T.solution(3, new int[][]{
                {1,1,0}, {1,1,1}, {0,1,1}
        }));
    }
}
