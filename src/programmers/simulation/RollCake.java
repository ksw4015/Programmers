package programmers.simulation;

public class RollCake {
    public int solution(int[] topping) {
        if(topping.length == 1)
            return 0;

        int[] cake1 = new int[10001];
        int[] cake2 = new int[10001];

        int topp1 = 0;
        int topp2 = 0;
        for(int i = 0 ; i < topping.length ; i++) {
            if(cake2[topping[i]] == 0)
                topp2++;
            cake2[topping[i]]++;
        }

        int answer = 0;
        for(int i = 0 ; i < topping.length ; i++) {
            if(cake2[topping[i]] > 0) {
                cake2[topping[i]]--;
                if(cake2[topping[i]] == 0)
                    topp2--;
            }

            if(cake1[topping[i]] == 0) {
                cake1[topping[i]]++;
                topp1++;
            }
            if(topp1 == topp2)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        RollCake T = new RollCake();
        System.out.println(T.solution(new int[]{1,2,1,3,1,4,1,2}));
        System.out.println(T.solution(new int[]{1,2,3,1,4}));
    }
}
