package programmers.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 중복순열 기초
 *
 */
public class PermutationWithRepetition {

    public static void main(String[] args) {
        DFS(new ArrayList<>(), 3, 3);
    }

    private static void DFS(List<Integer> result, int n, int m) {
        if(result.size() == m) {
            for(int p : result) {
                System.out.print(p + " ");
            }
            System.out.println();
        } else {
            for(int i = 1 ; i <= n ; i++) {
                result.add(i);
                DFS(result, n, m);
                result.remove(result.size()-1);
            }
        }
    }

}
