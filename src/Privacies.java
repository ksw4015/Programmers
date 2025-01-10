import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 프로그래머스
 * 개인정보 수집 유효기간
 *
 * 한 달은 28일
 * 1 년은 12달
 */
public class Privacies {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관 : 유효기간
        HashMap<String, Integer> termMap = new HashMap<>();
        for(String t : terms) {
            String[] term = t.split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]) * 28);
        }

        List<Integer> result = new ArrayList<>();
        int td = calcDate(today);
        for(int i = 0 ; i < privacies.length ; i++) {
            String[] pv = privacies[i].split(" ");
            int calc = calcDate(pv[0]) + termMap.get(pv[1]);
            if(td >= calc) {
                // 파기
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int calcDate(String day) {
        String[] d = day.split("\\.");
        int y = Integer.parseInt(d[0]) * 12 * 28;
        int m = (Integer.parseInt(d[1]) - 1) * 28;
        int dd = Integer.parseInt(d[2]);

        int sumDay = y + m + dd;
        return sumDay;
    }

    public static void main(String[] args) {
        Privacies T = new Privacies();
        System.out.println(Arrays.toString(T.solution(
                "2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
        )));
        System.out.println(Arrays.toString(T.solution(
                "2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}
        )));
    }
}
