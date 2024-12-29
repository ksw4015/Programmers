package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스
 *
 * 미로탈출
 */
public class EscapeMaze {
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for(int i = 0 ; i < maps.length ; i++) {
            char[] map = maps[i].toCharArray();
            for(int j = 0 ; j < map.length ; j++) {
                if(map[j] == 'L') {
                    lever = new int[]{i,j};
                } else if(map[j] == 'E') {
                    exit = new int[]{i,j};
                } else if(map[j] == 'S') {
                    start = new int[]{i,j};
                }
            }
        }
        // 시작지점부터 레버까지 거리
        answer += bfs(start, lever, maps);
        if(answer == -1)
            return -1;

        int exitRange = bfs(lever, exit, maps);
        if(exitRange == -1)
            return -1;
        return answer + exitRange;
    }

    private int bfs(int[] start, int[] end, String[] maps) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int[][] dir = new int[maps.length][maps[0].toCharArray().length];
        for(int[] d : dir) {
            Arrays.fill(d, 1000);
        }
        dir[start[0]][start[1]] = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].toCharArray().length];
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0 ; i < len ; i++) {
                int[] curr = queue.poll();
                for(int j = 0 ; j < dx.length ; j++) {
                    int nx = curr[0] + dx[j];
                    int ny = curr[1] + dy[j];
                    if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].toCharArray().length &&
                            maps[nx].charAt(ny) != 'X' && dir[nx][ny] > dir[curr[0]][curr[1]]) {
                        if(visited[nx][ny])
                            continue;
                        dir[nx][ny] = dir[curr[0]][curr[1]] + 1;
                        if(nx == end[0] && ny == end[1]) {
                            return dir[nx][ny];
                        }
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        EscapeMaze T = new EscapeMaze();
        System.out.println(T.solution(new String[]{
                "SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"
        }));
        System.out.println(T.solution(new String[]{
                "LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"
        }));
    }
}
