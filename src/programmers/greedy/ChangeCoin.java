package programmers.greedy;

import java.util.Scanner;

/**
 * 백준 그리디 문제집
 *
 * 거스름돈
 */
public class ChangeCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pay = sc.nextInt();

        int change = 1000 - pay;
        int[] coins = {500, 100, 50, 10, 5, 1};

        int count = 0;
        for (int coin : coins) {
            while (change / coin > 0) {
                count++;
                change -= coin;
            }
        }

        System.out.print(count);
    }
}
