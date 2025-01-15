package programmers.heap;

import java.util.*;

/**
 * 프로그래머스 디스크 컨트롤러
 *
 * 고득점 Kit
 * 우선순위 큐 문제
 *
 * 1. 어떤 작업 요청이 들어왔을 때 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장해 두는 대기 큐가 있습니다. 처음에 이 큐는 비어있습니다.
 * 2. 디스크 컨트롤러는 하드디스크가 작업을 하고 있지 않고 대기 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다.
 *    이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
 */
public class DiskController {
    static class Job {
        int start;  // 요청 시간
        int run;  // 소요 시간
        int num; // 작업 번호
        public Job(int start, int run, int num) {
            this.start = start;
            this.run = run;
            this.num = num;
        }
    }

    /**
     *
     * @param jobs 작업의 번호, 작업의 요청 시각, 작업의 소요 시간
     * @return
     */
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.run == o2.run) {
                if(o1.start == o2.start)
                    return o1.num - o2.num;
                return o1.start - o2.start;
            }
            return o1.run - o2.run;
        });

        for (int i = 0 ; i < jobs.length ; i++) {
            Job job = new Job(jobs[i][0], jobs[i][1], i);
            pq.add(job);
        }

        List<int[]> result = new ArrayList<>();  // 실제 작업 시작 시간, 종료 시간
        int time = 0;
        while (!pq.isEmpty()) {
            List<Job> temp = new ArrayList<>();
            int len = pq.size();
            boolean flag = false;
            for(int i = 0 ; i < len ; i++) {
                Job poll = pq.poll();
                if(poll.start <= time) {
                    if(poll.start < time) {
                        time += poll.run;
                    } else {
                        time = poll.start + poll.run;
                    }
                    result.add(new int[]{poll.start, time});
                    flag = true;
                    break;
                } else {
                    temp.add(poll);
                }
            }
            if(!flag)
                time++;
            pq.addAll(temp);
        }

        int sum = 0;
        for(int[] r : result) {
            sum += (r[1] - r[0]);
        }

        return sum / result.size();
    }

    public static void main(String[] args) {
        DiskController T = new DiskController();
        System.out.println(T.solution(new int[][]{
                {0,3}, {1,9}, {3,5}
        }));
        System.out.println(T.solution(new int[][]{
                {5, 10}, {6, 8}, {14, 2}, {11, 5}, {100, 7}
        }));
//        System.out.println(T.solution(new int[][]{
//                {0, 1}, {2, 2}, {2, 3}
//        }));
//        System.out.println(T.solution(new int[][]{
//                {0, 3}, {4,4}, {5,3}, {7, 1}
//        }));
    }
}
