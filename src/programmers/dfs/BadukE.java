package programmers.dfs;

/**
 * DFS 기초 바둑이
 *
 * 바둑이 몸무게 배열
 * 최대 용량
 *
 * 최대용량을 넘지 않는 바둑이들의 최대 무게 합
 */
public class BadukE {
    static int maxCapacity = 0;
    static int result = 0;

    public static void main(String[] args) {
        maxCapacity = 259;
        int[] baduks = new int[]{81, 58, 42, 33, 61};
        DFS(baduks, 0, 0);
        System.out.println(result);
    }

    private static void DFS(int[] baduks, int lv, int sum) {
        if(sum > maxCapacity)
            return;
        if(lv == baduks.length) {
            result = Math.max(sum, result);
            return;
        }
        DFS(baduks, lv + 1, sum);
        DFS(baduks, lv + 1, sum + baduks[lv]);
    }
}
