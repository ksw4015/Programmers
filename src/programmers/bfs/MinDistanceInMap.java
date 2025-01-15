package programmers.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 게임내 최단거리
 */
public class MinDistanceInMap {

    public int solution(int[][] maps) {
        int x = maps.length;
        int y = maps[0].length;

        int[][] dir = new int[x][y];
        for(int[] d : dir) {
            Arrays.fill(d, 1000);
        }
        dir[0][0] = 0;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                int[] curr = queue.poll();
                for(int j = 0 ; j < dx.length ; j++) {
                    int nx = curr[0] + dx[j];
                    int ny = curr[1] + dy[j];
                    if(nx >= 0 && nx < x && ny >= 0 && ny < y && maps[nx][ny] == 1 && dir[nx][ny] > dir[curr[0]][curr[1]] + 1) {
                        dir[nx][ny] = dir[curr[0]][curr[1]] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if(dir[x-1][y-1] == 1000)
            return -1;

        return dir[x-1][y-1]+1;
    }

    public static void main(String[] args) {
        MinDistanceInMap T = new MinDistanceInMap();
        System.out.println(T.solution(
                new int[][] {
                        {1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,0},
                        {0,0,0,0,1},
                }
        ));
    }
}
