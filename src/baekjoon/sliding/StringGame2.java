package baekjoon.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 20437 문자열 게임2
 */
public class StringGame2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 게임 진행횟수

        for(int i = 0 ; i < T ; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            // K가 1이면 모든 문자 하나짜리 문자열이 가능
            if (K == 1) {
                result.append("1 1\n");
                continue;
            }

            List<Integer>[] positions = new ArrayList[26];  // 알파벳 별 등장 인덱스
            for (int n = 0; n < 26; n++) {
                positions[n] = new ArrayList<>();
            }

            // 각 문자별 등장 위치 저장
            for (int n = 0; n < W.length(); n++) {
                positions[W.charAt(n) - 'a'].add(n);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            // 각 문자별로 K개 이상 등장하는 경우 찾기
            for (int n = 0; n < 26; n++) {
                if (positions[n].size() < K)
                    continue;  // K개 미만 등장하는 문자는 무시

                for (int j = 0; j <= positions[n].size() - K; j++) {
                    int len = positions[n].get(j + K - 1) - positions[n].get(j) + 1;
                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if (maxLen == -1) {
                result.append("-1\n");
            } else {
                result.append(minLen).append(" ").append(maxLen).append("\n");
            }
        }
        System.out.println(result);
    }
}
