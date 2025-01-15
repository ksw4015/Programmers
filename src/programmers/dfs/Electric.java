package programmers.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 전력망 둘로 나누기
 */
public class Electric {
    int result;

    public int solution(int n, int[][] wires) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] w : wires) {
            map.putIfAbsent(w[0], new ArrayList<>());
            map.putIfAbsent(w[1], new ArrayList<>());
            map.get(w[0]).add(w[1]);
            map.get(w[1]).add(w[0]);
        }

        result = Integer.MAX_VALUE;

        int[] chk = new int[n+1];
        dfs(map, chk, 1, n);

        return result;
    }

    private int dfs(Map<Integer, ArrayList<Integer>> map, int[] chk, int start, int n) {
        chk[start] = 1;
        int sum = 0;
        for(int next : map.get(start)) {
            if(chk[next] == 0) {
                int cnt = dfs(map, chk, next, n);
                result = Math.min(result, Math.abs((n-cnt)-cnt));
                sum += cnt;
            }
        }
        return sum+1;
    }

    public static void main(String[] args) {
        Electric T = new Electric();
        System.out.println(T.solution(9, new int[][]{
                {1,3},{2,3},{3,4},
                {4,5},{4,6},{4,7},
                {7,8},{7,9}
        }));
        System.out.println(T.solution(4, new int[][]{
                {1,2},{2,3},{3,4},
        }));
        System.out.println(T.solution(7, new int[][]{
                {1,2},{2,7},{3,7},
                {3,4},{4,5},{6,7}
        }));
    }
}
