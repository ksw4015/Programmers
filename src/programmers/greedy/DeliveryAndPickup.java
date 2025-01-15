package programmers.greedy;

public class DeliveryAndPickup {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        int d = 0;
        int p = 0;

        // 배열 뒤쪽부터 순회
        for(int i = n - 1 ; i >= 0 ; i--) {
            int cnt = 0;
            d -= deliveries[i];  // 집의 배달 수
            p -= pickups[i];  // 집의 수거 수
            while(d < 0 || p < 0) {
                d += cap;
                p += cap;
                cnt += 1; // 한번 왔다 감 (왕복?)
            }
            answer += (i + 1) * 2 * cnt;  // 왕복이라 * 2
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        DeliveryAndPickup T = new DeliveryAndPickup();
        System.out.println(T.solution(4, 5 ,new int[]{1,0,3,1,2}, new int[]{0,3,0,4,0}));
        System.out.println(T.solution(2, 7, new int[]{1,0,2,0,1,0,2}, new int[]{0,2,0,1,0,2,0}));
    }
}
