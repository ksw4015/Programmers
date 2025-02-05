package programmers.dfs.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AmazingPrime {
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // init
        result = new ArrayList<>();
        dfs(0, n, new StringBuilder());

        Collections.sort(result);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int num : result) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int lv,int n, StringBuilder sb) {
        if(lv == n) {
            int number = Integer.parseInt(sb.toString());
            result.add(number);
        } else {
            for(int i = 1 ; i <= 9 ; i++) {
                int number = Integer.parseInt(sb.toString() + i);
                if(!isPrime(number))
                    continue;
                dfs(lv + 1, n, sb.append(i));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private static boolean isPrime(int n) {
        if(n == 1)
            return false;

        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
