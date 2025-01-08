package dfs;

/**
 * 가장 가까운 큰 수
 *
 * 주어진 n을 똑같이 조합하여 n보다 큰 수 중 가장 가까운 수
 */
public class ClosestBigNumber {
    int max;
    int[] chk;

    public int solution(int n){
        max = Integer.MAX_VALUE;

        String number = String.valueOf(n);
        chk = new int[number.length()];

        dfs(String.valueOf(n), 0, "");
        if(max == Integer.MAX_VALUE)
            return -1;
        return max;
    }

    private void dfs(String s, int lv, String num) {
        if(lv == s.length()) {
            int number = Integer.valueOf(num);
            int ss = Integer.valueOf(s);
            if(number > ss) {
                max = Math.min(max, number);
            }
        } else {
            for(int i = 0 ; i < s.length() ; i++) {
                if(chk[i] == 0) {
                    chk[i] = 1;
                    dfs(s, lv + 1, num + s.charAt(i));
                    chk[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        ClosestBigNumber T = new ClosestBigNumber();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
