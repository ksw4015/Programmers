package leetcode;

/**
 * Leetcode 1422
 */
public class MaxScore {
    public int maxScore(String s) {
        int answer = 0;

        int left = 0;
        if(s.charAt(0) == '0')
            left += 1;

        int right = 0;
        for(int i = 1 ; i < s.length() ; i++) {
            if(s.charAt(i) == '1') {
                right++;
            }
        }
        answer = left + right;

        for(int i = 1 ; i < s.length() - 1 ; i++) {
            if(s.charAt(i) == '1') {
                right--;
            } else {
                left++;
            }
            answer = Math.max(answer, right + left);
        }

        return answer;
    }

    public static void main(String[] args) {
        MaxScore T = new MaxScore();
        System.out.println(T.maxScore("011101"));
        System.out.println(T.maxScore("00111"));
        System.out.println(T.maxScore("1111"));
    }
}
