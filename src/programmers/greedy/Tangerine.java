package programmers.greedy;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * 프로그래머스
 * 귤 고르기
 *
 * 그리디
 *
 * 배열에 귤의 크기가 들어있음
 * K개의 귤을 고를때 가장 적은 종류로 고를 수 있도록 작성
 *
 * k	tangerine	result
 * 6	[1, 3, 2, 5, 4, 5, 2, 3]	3
 * 4	[1, 3, 2, 5, 4, 5, 2, 3]	2
 * 2	[1, 1, 1, 1, 2, 2, 2, 3]	1
 */
public class Tangerine {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        ArrayList<int[]> list = new ArrayList<>();
        for(int t : map.keySet()) {
            list.add(new int[]{t, map.get(t)});
        }
        list.sort((o1, o2) -> o2[1] - o1[1]);

        int answer = 0;
        int cnt = 0;
        for(int[] tt : list) {
            cnt += tt[1];  // 귤 개수
            answer++;
            if(cnt >= k)
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        Tangerine T = new Tangerine();
        System.out.println(T.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}
