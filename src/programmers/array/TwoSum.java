package programmers.array;

import java.util.TreeSet;

/**
 * 프로그래머스
 * 두 개 뽑아서 더하기
 *    입력            출력
 * [2,1,3,4,1] -> [2,3,4,5,6,7]
 * [5,0,2,7] -> [2,5,7,9,12]
 */
public class TwoSum {

    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0 ; i < numbers.length - 1 ; i++) {
            for(int j = i+1 ; j < numbers.length ; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
    }
}
