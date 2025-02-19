package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준
 * 단축키 지정
 *
 */
public class ShortCut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        int[] chk = new int[26];
        for(int i = 0 ; i < n ; i++) {
            String[] word = br.readLine().split(" ");

            boolean replace = false;
            for(int j = 0 ; j < word.length ; j++) {
                if(shortcutFirst(word[j].toLowerCase(), chk)) {
                    StringBuilder sb = new StringBuilder(word[j]);
                    sb.replace(0, 1, "[" + word[j].charAt(0) + "]");
                    word[j] = sb.toString();
                    replace = true;
                    break;
                }
            }

            if(!replace) {
                for(int k = 0 ; k < word.length ; k++) {
                    String shortcut = shortcutRemain(word[k], chk);
                    if(!word[k].equals(shortcut)) {
                        word[k] = shortcut;
                        break;
                    }
                }
            }
            list.add(String.join(" ", word));
        }

        for(String result : list) {
            System.out.println(result);
        }
    }

    private static boolean shortcutFirst(String s, int[] chk) {
        int position = s.charAt(0) - 'a';
        if(position >= 0 && position < 26) {
            if (chk[position] == 0) {
                chk[position] = 1;
                return true;
            }
        }
        return false;
    }

    private static String shortcutRemain(String s, int[] chk) {
        if(s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        boolean find = false;

        String lower = s.toLowerCase();
        for(int i = 1 ; i < lower.length() ; i++) {
            int position = lower.charAt(i) - 'a';
            if(position < 0 || position > 25) {
                sb.append(s.charAt(i));
                continue;
            }
            if(!find && chk[position] == 0) {
                chk[position] = 1;
                find = true;
                sb.append("[").append(s.charAt(i)).append("]");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
