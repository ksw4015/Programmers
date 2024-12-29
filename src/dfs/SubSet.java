package dfs;

/**
 * DFS 기초 (인프런)
 *
 * 부분집합 구하기
 */
public class SubSet {
    static int[] ch;

    public static void main(String[] rags) {
        int n = 3;
        ch = new int[n+1];
        dfs(n, 1);
    }

    private static void dfs(int n, int start) {
        if(start == n + 1) {
            for(int i = 1 ; i < ch.length ; i++) {
                if(ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        ch[start] = 1;
        dfs(n, start + 1);
        ch[start] = 0;
        dfs(n, start + 1);
    }
}
