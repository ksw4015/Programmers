package baekjoon.simulation;

import java.util.Scanner;

/**
 * 백준 빗물
 *
 */
public class RainDrop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;

        int result = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if(leftMax <= rightMax) {
                result += (leftMax - arr[left]);
                left++;
            } else {
                result += (rightMax - arr[right]);
                right--;
            }
        }

        System.out.println(result);
    }
}
