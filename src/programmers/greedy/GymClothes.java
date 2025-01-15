package programmers.greedy;

import java.util.Arrays;

/**
 * 프로그래머스 체육복
 *
 * 그리디
 *
 * n: 전체 학생수
 * lost: 체육복 잃어버린 놈들
 * reserve: 여분의 체육복이 있는 놈들
 *
 * 여분의 체육복있는놈이 잃어버리면 못 빌려줌 (1개 뿐이라)
 *
 * n	lost	reserve	return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	        4
 * 3	[3]	    [1]	        2
 */
public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+2];
        Arrays.fill(student, 1);
        for (int j : lost) {
            student[j] = 0; // 잃어버린 놈 -1
        }
        for (int j : reserve) {
            if (student[j] == 0) {
                student[j] = 1;
            } else {
                student[j] = 2;
            }
        }

        for(int i = 1 ; i < n+1 ; i++) {
            if(student[i] == 0){
                if(student[i-1] == 2) {
                    student[i-1] = 1;
                    student[i] = 1;
                } else if(student[i+1] == 2) {
                    student[i] = 1;
                    student[i+1] = 1;
                }
            }
        }

        int answer = 0;
        for(int s : student) {
            if(s > 0)
                answer++;
        }
        System.out.println(Arrays.toString(student));
        return answer-2;
    }

    public static void main(String[] args) {
        GymClothes T = new GymClothes();
//        System.out.println(T.solution(5, new int[]{2,4}, new int[]{1,3,5}));
//        System.out.println(T.solution(5, new int[]{2,4}, new int[]{3}));
//        System.out.println(T.solution(3, new int[]{3}, new int[]{1}));
        System.out.println(T.solution(5, new int[]{5}, new int[]{4}));
    }
}
