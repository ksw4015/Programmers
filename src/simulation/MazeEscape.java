package simulation;

/**
 * 프로그래머스 미로탈출 명령어
 *
 * DFS나 BFS 탐색 문제인줄 알았으나, 구현 문제
 *
 */
public class MazeEscape {
    // 명령어
    String[] command = {"d", "l", "r", "u"};  // 사전순
    // 좌표
    int[] dx = {1, 0, 0, -1};  // 행
    int[] dy = {0, -1, 1, 0};  // 열

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 이동이 가능한지
        int distance = Math.abs(x - r) + Math.abs(y - c);
        if(distance > k) {
            return "impossible";
        } else if((k - distance) % 2 != 0){
            return "impossible";
        }

        // 현재 이동한 좌표
        int cx = x;
        int cy = y;
        // 명령어 저장
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            // 사전순으로 명령어 순회
            for(int i = 0 ; i < command.length ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 다음 좌표로 이동이 가능한 지
                if(nx > 0 && nx <= n && ny > 0 && ny <= m) {
                    // 이동한 좌표에서 목적지까지 남은 거리가 K 보다 작은지 (계속 이동하기 위해)
                    if(Math.abs(r - nx) + Math.abs(c - ny) < k) {
                        // 이동 가능하면 현재 좌표 수정
                        cx = nx;
                        cy = ny;
                        // k 차감
                        k--;
                        // 명령어 추가
                        sb.append(command[i]);
                        break;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MazeEscape T = new MazeEscape();
        System.out.println(T.solution(3,4,2,3,3,1,5));
        System.out.println(T.solution(2,2,1,1,2,2,2));
        System.out.println(T.solution(3,3,1,2,3,3,4));
    }
}
