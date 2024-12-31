package dfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스
 *
 * 양궁대회
 *
 */
public class ArcheryContest {
    static ArrayList<int[]> result;
    static int diff;
    static int max;

    public int[] solution(int n, int[] info) {
        result = new ArrayList<>();
        diff = 0;
        max = 0;
        dfs(0, 0, n, info, new int[info.length]);

        if(result.size() == 0)
            return new int[]{-1};

        int[] answer = result.get(result.size()-1);
        for(int[] r : result) {
            for(int i = 10 ; i >= 0 ; i--) {
                if (answer[i] > r[i] && checkScore(r, info)) {
                    answer = r.clone();
                    break;
                }
            }
        }
        return answer;
    }

    private boolean checkScore(int[] a, int[] info) {
        int score = 0;
        for(int i = 0 ; i < info.length ; i++) {
            if(a[i] == 0 && info[i] == 0)
                continue;
            int s = 10 - i;
            if(a[i] > info[i]) {
                score += s;
            }
        }
        return score == max;
    }

    private void dfs(int arrows, int start, int n, int[] info, int[] scores) {
        if(arrows >= n) {
            int a = 0; // 라이언
            int b = 0; // 어피치
            for(int i = 0 ; i < info.length ; i++) {
                if(scores[i] == 0 && info[i] == 0)
                    continue;
                int score = 10 - i;
                if(scores[i] > info[i]) {
                    a += score;
                } else {
                    b += score;
                }
            }
            if(a > b && diff <= Math.abs(a-b)) {
                if(max < a)
                    max = a;
                diff = Math.abs(a-b);
                result.add(scores.clone());
            }
        } else {
            for(int i = start ; i < info.length ; i++) {
                int arr = arrows + info[i] + 1;
                int next = i + 1;
                if(arr > n) {
                    scores[i] = arr-n;
                } else {
                    scores[i] = info[i] + 1;
                }
                dfs(arr, next, n, info, scores);
                scores[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        ArcheryContest T = new ArcheryContest();
        System.out.println(Arrays.toString(T.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(T.solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(T.solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1})));
        System.out.println(Arrays.toString(T.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3})));
    }
}
