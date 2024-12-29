package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 프로그래머스
 * 모의고사 (완전탐색)
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 가장 많이 맞춘 수포자 반환
 * 가장 많이 맞춘 수포자가 여러명일땐 오름차순 정렬해서 반환
 */
public class PracticeExam {
    public int[] solution(int[] answers) {
        int[] supoza1 = {1, 2, 3, 4, 5};
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[][] scores = new int[3][2];
        scores[0][0] = 1;
        scores[1][0] = 2;
        scores[2][0] = 3;

        for(int i = 0 ; i < answers.length ; i++) {
            if(answers[i] == supoza1[i % supoza1.length]) {
                scores[0][1]++;
            }
            if(answers[i] == supoza2[i % supoza2.length]) {
                scores[1][1]++;
            }
            if(answers[i] == supoza3[i % supoza3.length]) {
                scores[2][1]++;
            }
        }
        Arrays.sort(scores, Comparator.comparingInt(o -> o[1]));

        ArrayList<Integer> result = new ArrayList<>();
        result.add(scores[2][0]); // 가장 많이 맞춘 사람
        for(int i = 1 ; i >= 0 ; i--) {
            if(scores[i][1] == scores[2][1])  // 가장 많이 맞춘사람과 점수가 같으면 result에 삽입
                result.add(scores[i][0]);
        }

        Collections.sort(result);  // 가장 많이 맞춘사람들 정렬
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        PracticeExam T = new PracticeExam();
        System.out.println(Arrays.toString(T.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1,3,2,4,2})));
    }
}
