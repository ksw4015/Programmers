package simulation;

import java.util.Arrays;

/**
 * 프로그래머스 쿼드 압축
 */
public class QuadZip {
    int zero;
    int one;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        if(!zip(arr)) {
            quadZip(arr);
        }
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }

    private void quadZip(int[][] arr) {
        if(arr.length == 1) {
            if(arr[0][0] == 1)
                one++;
            else
                zero++;
        } else {
            if(!zip(arr)) {
                int range = arr.length / 2;
                int[][] arr1 = new int[range][range];
                int[][] arr2 = new int[range][range];
                for(int i = 0 ; i < range ; i++) {
                    arr1[i] = Arrays.copyOfRange(arr[i], 0, range);
                    arr2[i] = Arrays.copyOfRange(arr[i], range, arr[i].length);
                }
                quadZip(arr1);
                quadZip(arr2);
                int[][] arr3 = new int[range][range];
                int[][] arr4 = new int[range][range];
                for(int i = range ; i < arr.length ; i++) {
                    arr3[i - range] = Arrays.copyOfRange(arr[i], 0, range);
                    arr4[i - range] = Arrays.copyOfRange(arr[i], range, arr[i].length);
                }
                quadZip(arr3);
                quadZip(arr4);
            }
        }
    }

    private boolean zip(int[][] arr) {
        int start = arr[0][0];
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = 0 ; j < arr[i].length ; j++) {
                if(arr[i][j] != start)
                    return false;
            }
        }
        if(start == 1)
            one++;
        else
            zero++;
        return true;
    }

    public static void main(String[] args) {
        QuadZip T = new QuadZip();
        System.out.println(Arrays.toString(T.solution(
                new int[][] {
                        {1,1,0,0}, {1,0,0,0}, {1,0,0,1}, {1,1,1,1}
                }
        )));
        System.out.println(Arrays.toString(T.solution(
                new int[][] {
                        {1,1,0,0}, {1,0,0,0}, {1,0,0,1}, {1,1,1,1}
                }
        )));
    }
}
