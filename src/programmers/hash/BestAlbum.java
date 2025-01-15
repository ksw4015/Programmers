package programmers.hash;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, PriorityQueue<int[]>> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < genres.length ; i++) {
            map.putIfAbsent(genres[i], new PriorityQueue<>((o1, o2) -> {
                if(o1[1] == o2[1])
                    return o1[0]-o2[0]; // 고유번호 낮은순서
                return o2[1]-o1[1]; // 재생 많은 순서
            }));
            map.get(genres[i]).add(new int[]{i, plays[i]});
            map2.put(genres[i], map2.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> g = map2.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for(String gen : g) {
            PriorityQueue<int[]> pq = map.get(gen);
            if(pq.size() == 1) {
                result.add(pq.poll()[0]);
            } else {
                for(int i = 0 ; i < 2 ; i++) {
                    result.add(pq.poll()[0]);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        BestAlbum T = new BestAlbum();
        System.out.println(Arrays.toString(T.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        )));
    }
}
