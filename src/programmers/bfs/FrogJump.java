package programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FrogJump {
    public int solution(int[] nums) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // 시작 지점 삽입
        int[] visited = new int[nums.length];
        visited[0] = 1;
        while (!queue.isEmpty()) {
            answer++;
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                int curr = queue.poll(); // 현재 징검다리
                if(nums[curr] != 0) {
                    // 앞으로 뒤로 점프 가능
                    int front = curr + nums[curr];
                    int back = curr - nums[curr];
                    if(front == nums.length - 1 || back == nums.length - 1)
                        return answer;
                    if (front < nums.length && visited[front] == 0) {
                        visited[front] = 1;
                        queue.add(front);
                    }
                    if (back >= 0 && visited[back] == 0) {
                        visited[back] = 1;
                        queue.add(back);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FrogJump T = new FrogJump();
        System.out.println(T.solution(new int[]{4,1,2,3,1,0,5}));
    }
}
