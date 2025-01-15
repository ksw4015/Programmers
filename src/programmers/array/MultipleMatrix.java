package programmers.array;

import java.util.Arrays;

/**
 * 프로그래머스
 * 행렬의 곱
 *
 * arr1과 arr2를 곱한값 반환
 *
 * Tip. arr1은 가로먼저 순회, arr2는 세로먼저 순회
 */
public class MultipleMatrix {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        return multiple(arr1, arr2);
    }

    /**
     * arr1의 열의 개수 == arr2의 행의 개수?
     *
     * @param arr1 행의 개수가 더 많은 배열
     * @param arr2 행의 개수가 더 적은 배열
     * @return
     */
    private int[][] multiple(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for(int k = 0 ; k < arr1[0].length ; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MultipleMatrix T = new MultipleMatrix();
        int[][] result = T.solution(
                new int[][]{
                        {1,4}, {3,2}, {4,1}
                },
                new int[][]{
                        {3,3}, {3,3}
                }
        );

        for(int i = 0 ; i < result.length ; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
