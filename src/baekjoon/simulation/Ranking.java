package baekjoon.simulation;

import java.util.*;

/**
 * 백준 1205
 * 등수 구하기
 */
public class Ranking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 렝카 숫자
        if(n == 0) {
            System.out.println(1); // 랭커가 없으면 내가 1등
            return;
        }

        int score = sc.nextInt();  // 점수
        int rankingSize = sc.nextInt(); // 랭킹 보드 사이즈

        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);  // 점수 내림차순 Map
        for(int i = 0 ; i < n ; i++) {
            int rankScore = sc.nextInt();
            map.put(rankScore, map.getOrDefault(rankScore, 0) + 1);  // 점수에 몇명있는지
        }

        int high = 0;
        for(int s : map.keySet()) {
            if(s > score) {  // 나보다 같거나 높은 점수 받은 사람의 수 덧셈
                high += map.get(s);
            } else {
                break;
            }
        }

        if(map.containsKey(score)) {
            if(high + map.get(score) >= rankingSize) {
                System.out.println(-1);
                return;
            }
        }
        if(high + 1 > rankingSize) {
            System.out.println(-1);
        } else {
            System.out.println(high + 1);
        }
    }
}
