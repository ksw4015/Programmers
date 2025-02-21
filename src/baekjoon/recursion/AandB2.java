package baekjoon.recursion;

import java.util.Scanner;

/**
 * 백준 12919
 * A와 B 2
 */
public class AandB2 {
    static String a;
    static boolean success = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        String b = sc.next();
        dfs(b);

        if(success) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(String s) {
        if(success)
            return;
        if(s.length() == a.length()) {
            if(s.equals(a)) {
                success = true;
            }
        } else {
            // 마지막 문자가 'A'면 제거
            if (s.charAt(s.length() - 1) == 'A') {
                dfs(s.substring(0, s.length() - 1));
            }
            // 첫 번째 문자가 'B'면 뒤집고 'B' 제거
            if (s.charAt(0) == 'B') {
                dfs(new StringBuilder(s).reverse().substring(0, s.length() - 1));
            }
        }
    }
}
