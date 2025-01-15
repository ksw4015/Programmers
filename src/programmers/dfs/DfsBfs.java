package programmers.dfs;

import java.util.*;

/**
 * 백준 DFS와 BFS
 */
public class DfsBfs {
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int[] chk;
    static String result = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        chk = new int[n+1];

        for(int i = 0 ; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        for(int k : map.keySet()) {
            map.get(k).sort(Comparator.naturalOrder());
        }

        dfs(v);
        System.out.println(result);
        // 초기화
        result = "";
        chk = new int[n+1];

        bfs(v);
        System.out.println(result);
    }

    private static void dfs(int v) {
        if(chk[v] == 0) {
            chk[v] = 1;
            result += v + " ";
            if(map.containsKey(v)) {
                for(int d : map.get(v)) {
                    dfs(d);
                }
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        chk[v] = 1;
        result += v + " ";
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if(map.containsKey(node)) {
                for(int k : map.get(node)) {
                    if(chk[k] == 0) {
                        chk[k] = 1;
                        result += k + " ";
                        queue.add(k);
                    }
                }
            }
        }
    }
}
