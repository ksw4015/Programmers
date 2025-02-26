package baekjoon;

import java.util.Scanner;

public class SnailHope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int s = v - a;
        int n = a - b;

        int result = (int) Math.ceil((double) s / n) + 1;
        System.out.println(result);
    }
}
