package baekjoon.simulation;

import java.util.*;

/**
 * 20055번
 *
 * 컨베이어 벨트 위 로봇
 *
 */
public class BeltRobot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // 벨트 (내구도)
        List<Integer> belt = new ArrayList<>();
        for(int i = 0 ; i < 2 * N ; i++) {
            belt.add(sc.nextInt());
        }

        int count = 0;
        int result = 0;

        // 로봇이 있는 위치 큐
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            result++;

            // 1. 벨트 회전
            int last = belt.remove(belt.size()-1);
            belt.add(0, last);

            // 1-1. 로봇 위치 변경 (한 칸씩 이동)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                int newIndex = index + 1; // 로봇도 한 칸 이동
                if (newIndex < N - 1) { // N-1이면 로봇 삭제
                    queue.add(newIndex);
                }
            }

            // 2. 벨트 위에 로봇이 있으면 1칸씩 이동
            //   - 옆칸 내구도가 0보다 크고 다른 로봇이 없어야 됨
            //   - 옆칸이 N-1 이면 로봇 삭제
            if(!queue.isEmpty()) {
                size = queue.size();
                for(int j = 0 ; j < size ; j++) {
                    int index = queue.poll();
                    int nextIndex = index + 1;
                    // 이동하려는 곳에 로봇이 없고, 내구도가 0보다 커야 됨
                    if(belt.get(nextIndex) > 0 && !queue.contains(nextIndex)) {
                        belt.set(nextIndex, belt.get(nextIndex) - 1);
                        if (belt.get(nextIndex) == 0) {
                            count++;
                        }
                        if (nextIndex < N - 1) { // 내리는 위치(N-1) 도착하면 제거
                            queue.add(nextIndex);
                        }
                    } else {
                        queue.add(index);
                    }
                }
            }

            // 3. 벨트 0번 내구도가 0이 아니면 올리기
            if(belt.get(0) > 0) {
                belt.set(0, belt.get(0) - 1);
                queue.add(0);
                if(belt.get(0) == 0) {
                    count += 1;
                }
            }

            if(count >= K)
                break;
        }

        System.out.println(result);
    }
}
