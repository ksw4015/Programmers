package hash;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  백준 11723
 *  집합
 *
 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
 * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
 * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 * all: S를 {1, 2, ..., 20} 으로 바꾼다.
 * empty: S를 공집합으로 바꾼다.
 */

public class SetProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> all = new ArrayList<>();
        for(int i = 1 ; i <= 20 ; i++) {
            all.add(i);
        }

        HashSet<Integer> set = new HashSet<>();
        String command;
        int number;
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            if(command.equals("all")) {
                set.addAll(all);
                continue;
            } else if(command.equals("empty")) {
                set.clear();
                continue;
            }
            number = Integer.parseInt(st.nextToken());
            if(command.equals("add")) {
                set.add(number);
            } else if(command.equals("remove")) {
                set.remove(number);
            } else if(command.equals("toggle")) {
                if(set.contains(number))
                    set.remove(number);
                else
                    set.add(number);
            } else {
                if(set.contains(number))
                    bw.write(1 + "\n");
                else
                    bw.write(0 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
