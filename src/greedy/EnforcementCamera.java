package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  프로그래머스 단속 카메라
 *
 *  모든 차량이 1번은 찍히게끔 배치
 */
public class EnforcementCamera {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int answer = 1;
        int exitTime = routes[0][1];
        for(int i = 1 ; i < routes.length ; i++) {
            int enter = routes[i][0];
            int exit = routes[i][1];
            if(exitTime < enter) {
                answer++;
                exitTime = exit;
            } else {
                if(exit < exitTime) {
                    exitTime = exit;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        EnforcementCamera T = new EnforcementCamera();
        System.out.println(T.solution(new int[][]{
                {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}
        }));
    }
}
