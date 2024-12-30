package sort;

import java.util.ArrayList;

public class BiggestNumber {
    public String solution(int[] numbers) {
        ArrayList<String> nums = new ArrayList<>();
        for(int i : numbers) {
            nums.add(String.valueOf(i));
        }
        nums.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for(String s : nums) {
            sb.append(s);
        }
        if(nums.get(0).startsWith("0"))
            return "0";

        return sb.toString();
    }

    public static void main(String[] args) {
        BiggestNumber T = new BiggestNumber();
        System.out.println(T.solution(new int[]{6,10,2}));
        System.out.println(T.solution(new int[]{3,30,34,5,9}));
    }
}
