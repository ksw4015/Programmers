package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> idMap = new HashMap<>();
        for(int i = 0 ; i < id_list.length ; i++) {
            idMap.put(id_list[i], i);
        }

        // K = 신고자, V = 신고대상자 들
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(String re : report) {
            String[] ss = re.split(" ");
            map.putIfAbsent(ss[0], new HashSet<>());
            map.get(ss[0]).add(ss[1]);
        }
        // 각 유저가 몇번 신고됐는지
        HashMap<String, Integer> map2 = new HashMap<>();
        for(String key : map.keySet()) {
            for(String name : map.get(key)) {
                map2.put(name, map2.getOrDefault(name, 0) + 1);
            }
        }

        for(String key : map.keySet()) {
            int cnt = 0;
            for(String name : map.get(key)) {
                if(map2.containsKey(name)) {
                    if(map2.get(name) >= k)
                        cnt++;
                }
            }
            answer[idMap.get(key)] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        ReportResult T = new ReportResult();
        System.out.println(Arrays.toString(T.solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
        )));
        System.out.println(Arrays.toString(T.solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3
        )));
    }
}
