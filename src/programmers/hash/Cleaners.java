package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cleaners {
    public int solution(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        boolean end = false;
        for(int i = 1 ; i <= numbers.length ; i++) {
            if(map.get(i) == null) {
                return i;
            } else if(map.get(i) > 1) {
                end = true;
            } else if(end){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Cleaners T = new Cleaners();
        System.out.println(T.solution(new int[]{5,3,4,1}));
        System.out.println(T.solution(new int[]{2,1,3,3,4,7}));
        System.out.println(T.solution(new int[]{1,2}));
        System.out.println(T.solution(new int[]{6,1,2,5,5}));
    }
}
