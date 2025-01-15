package programmers.array;

import java.util.*;

/**
 * 프로그래머스
 * 방문길이
 */
public class VisitRange {
    /*
        dirs의 길이는 500자 이하
        U, D, L ,R
        위 아래 왼쪽 오른쪽
        x,y 범위는 -5 ~ 5
     */
    public int solution(String dirs) {
        HashSet<String> result = new HashSet<>();
        // 시작 포지션 x(행),y(열)
        int[] prev = new int[]{0, 0};
        int[] curr = new int[]{0, 0};

        for(int i = 0 ; i < dirs.length() ; i++) {
            char dir = dirs.charAt(i);
            if(dir == 'U') { // 위
                if(curr[1] == 5)
                    continue;
                curr[1] += 1;
            } else if(dir == 'D') { // 아래
                if(curr[1] == -5)
                    continue;
                curr[1] -= 1;
            } else if(dir == 'L') { // 왼쪽
                if(curr[0] == -5)
                    continue;
                curr[0] -= 1;
            } else { // 오른쪽
                if(curr[0] == 5)
                    continue;
                curr[0] += 1;
            }

            String nx = prev[0] + "," + prev[1] + " " + curr[0] + "," + curr[1];
            String nx1 = curr[0] + "," + curr[1] + " " + prev[0] + "," + prev[1];

            result.add(nx);
            result.add(nx1);

            prev = new int[]{curr[0], curr[1]};
        }
        return result.size() / 2;
    }

    public static void main(String[] args) {
        VisitRange T = new VisitRange();
        System.out.println(T.solution("ULURRDLLU"));
        System.out.println(T.solution("LULLLLLLU"));
    }
}
