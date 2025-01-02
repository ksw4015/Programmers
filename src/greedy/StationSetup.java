package greedy;

/**
 * 프로그래머스 기지국 설치
 *
 * N은 전체 아파트 수
 * stations는 기지국이 설치된 아파트
 * w는 범위
 *
 * N	stations	W	answer
 * 11	[4, 11]	    1	3
 * 16	[9]	        2	3
 */
public class StationSetup {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        for(int i = 0 ; i <= stations.length ; i++) {
            int len;  // 기지국 전파가 닿지않는 공간
            if(i == 0) {
                len = stations[i] - w - 1;
            } else if(i == stations.length) {
                len = n - stations[i-1] - w;
            } else {
                // 이전 기지국과 다음 기지국 사이에 전파가 닿지않는 거리
                len = stations[i] - stations[i-1] - (w * 2) - 1;
            }

            if(len > 0) {
                int cnt = len / (w * 2 + 1);
                int remain = len % (w * 2 + 1);
                answer += cnt;
                if(remain != 0)
                    answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StationSetup T = new StationSetup();
        System.out.println(T.solution(
                11, new int[]{4,11}, 1
        ));
        System.out.println(T.solution(
                16, new int[]{9}, 2
        ));
    }
}
