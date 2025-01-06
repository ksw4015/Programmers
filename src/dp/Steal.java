package dp;

public class Steal {
    private static int solution(int[] money) {
        int n = money.length;
        // 첫번째 집 훔침 (마지막 집 X)
        // 반복 범위 2 ~ 마지막집 제외
        int[] dy1 = new int[n];
        // 마지막 집 훔침 (첫번째 집 X)
        // 반복 범위 2 ~ 끝까지
        int[] dy2 = new int[n];

        dy1[0] = money[0];
        dy1[1] = Math.max(money[0], money[1]);
        for(int i = 2 ; i < n - 1 ; i++) {
            dy1[i] = Math.max(dy1[i-1], dy1[i-2] + money[i]);
        }

        dy2[0] = 0;
        dy2[1] = money[1];
        for(int i = 2 ; i < n ; i++) {
            dy2[i] = Math.max(dy2[i-1], dy2[i-2] + money[i]);
        }

        return Math.max(dy1[n-2], dy2[n-1]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,1}));
    }
}
