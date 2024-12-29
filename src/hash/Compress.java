package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 프로그래머스 압축
 */
public class Compress {
    public static void main(String[] args) {
        Compress T = new Compress();
        System.out.println(Arrays.toString(T.solution("KAKAO")));
    }

    public int[] solution(String msg) {
        // 사전
        HashMap<String, Integer> dic = new HashMap<>();
        String init = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // 사전 초기화
        for(int i = 0 ; i < init.length() ; i++) {
            dic.put(String.valueOf(init.charAt(i)), i+1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < msg.length(); ) {
            String temp = "";
            int length = 0;

            // 가장 긴 일치 문자열을 찾음
            // 사전에 있으면 계속 문자열 더하기
            // 없으면 탈출
            while (i + length < msg.length() && dic.containsKey(temp + msg.charAt(i + length))) {
                temp += msg.charAt(i + length);
                length++;
            }

            // 일치 문자열의 인덱스를 저장
            // 사전에 있는 가장 긴 문자열 색인번호 출력
            result.add(dic.get(temp));

            // 없었던 문자열은 앞에서 출력한 문자열 + 1한 문자열
            // 새로운 패턴을 추가
            if (i + length < msg.length()) {
                dic.put(temp + msg.charAt(i + length), dic.size() + 1);
            }

            i += length;  // 위치를 업데이트
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
