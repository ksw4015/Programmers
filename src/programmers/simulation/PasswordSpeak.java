package programmers.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordSpeak {
    static List<Character> vowel;

    public static void main(String[] args) {
        vowel = new ArrayList<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        List<String> result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if(s.equals("end"))
                break;

            boolean containV = false;
            boolean accept = true;

            char[] cArr = s.toCharArray();

            int a = 0;
            int b = 0;
            for(int i = 0 ; i < cArr.length ; i++) {
                if(!containV && vowel.contains(cArr[i])) {
                    containV = true;
                }
                if(vowel.contains(cArr[i])) {
                    a += 1;
                    b = 0;
                } else {
                    a = 0;
                    b += 1;
                }
                if(a == 3 || b == 3) {
                    accept = false;
                    break;
                }
                if(i > 0 && cArr[i-1] == cArr[i] && cArr[i] != 'e' && cArr[i] != 'o') {
                    accept = false;
                    break;
                }
            }

            if(accept && containV) {
                result.add("<" + s + "> is acceptable.");
            } else {
                result.add("<" + s + "> is not acceptable.");
            }
        }

        for(String r : result) {
            System.out.println(r);
        }
    }
}
