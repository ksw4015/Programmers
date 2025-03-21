package softeer.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SecretMenu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 비밀메뉴 버튼 커맨드
        int M = Integer.parseInt(st.nextToken());
        // 사용자 입력 버튼 커맨드
        int N = Integer.parseInt(st.nextToken());
        // 버튼 숫자
        int K = Integer.parseInt(st.nextToken());

        String secretComm = br.readLine().replace(" ", "");
        String userComm = br.readLine().replace(" ", "");

        if(secretComm.length() > userComm.length()) {
            System.out.println("normal");
            return;
        }

        // 초기 체크
        if(userComm.substring(0, M).equals(secretComm)) {
            System.out.println("secret");
            return;
        }

        StringBuilder sb = new StringBuilder(userComm.substring(0, M));
        for(int i = 1 ; i <= N - M ; i++) {
            sb.deleteCharAt(0);
            sb.append(userComm.charAt(i + M - 1));
            if(sb.toString().equals(secretComm)) {
                System.out.println("secret");
                return;
            }
        }
        System.out.println("normal");
    }
}
