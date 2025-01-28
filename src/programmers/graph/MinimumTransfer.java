package programmers.graph;

import java.util.*;

public class MinimumTransfer {
    public int solution(int[][] routes, int s, int e){
        // K: 호선
        // V: 갈 수 있는 역 번호
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < routes.length ; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            for(int j = 0 ; j < routes[i].length ; j++) {
                map.get(i).add(routes[i][j]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int lv = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                int curr = queue.poll();
                for(int st : map.keySet()) {
                    if(map.get(st).contains(curr)) {
                        for(int t : map.get(st)) {
                            if(t == e)
                                return lv;
                            queue.add(t);
                        }
                    }
                }
            }
            lv++;
        }
        return -1;
    }

    public static void main(String[] args){
        MinimumTransfer T = new MinimumTransfer();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
