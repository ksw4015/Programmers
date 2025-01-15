package programmers.hash;

import java.util.*;

/**
 * 프로그래머스
 */
public class MenuRenewal {
    public static void main(String[] args) {
        MenuRenewal T = new MenuRenewal();
        String[] answer = T.solution(
                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2,3,4}
        );
        System.out.println(Arrays.toString(answer));
    }

    static HashMap<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for(int co : course) {
            courseMap.putIfAbsent(co, new HashMap<>());
        }

        for(String order : orders) {
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar);
            dfs(orderChar, 0, 0, "");
        }

        ArrayList<String> answer = new ArrayList<>();
        for(HashMap<String, Integer> count : courseMap.values()) {
            count.values().stream()
                    .max(Comparator.comparingInt(o -> o))
                    .ifPresent(cnt -> count.entrySet().stream()
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            .forEach(entry -> answer.add(entry.getKey()))
                    );
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    // 조합 기록을 String으로
    private static void dfs(char[] order, int start, int lv, String course) {
        if(courseMap.containsKey(lv)) {
            HashMap<String, Integer> map = courseMap.get(lv);
            map.put(course, map.getOrDefault(course, 0) + 1);
        }
        for(int i = start ; i < order.length ; i++) {
            dfs(order, i + 1, lv + 1 , course + order[i]);
        }
    }
}
