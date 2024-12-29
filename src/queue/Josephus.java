package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 몸풀기 문제
 * 1부터 N까지 사람이 있고
 * K가 주어지면 K번째 사람 제거 후 제거된 사람 이후부터 다시 순회
 *
 * 마지막에 살아있는 사람 번호를 반환
 */
public class Josephus {
    public int solution(int n, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for(int i = 0 ; i < k ; i++) {
                int poll = queue.poll();
                if(i < k-1) {
                    queue.add(poll);
                }
            }
        }
        answer = queue.peek();
        return answer;
    }

    public static void main(String[] args) {
        Josephus T = new Josephus();
        System.out.println(T.solution(5, 2));  // expect: 3
    }
}
