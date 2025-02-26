package baekjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Population {
    // N: 크기
    // L: 최소값
    // R: 최대값
    static int N, L, R;

    static int[][] map;

    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dayCount = 0;

        while (true) {
            // 인구이동 한 번 끝날때마다 초기화
            visited = new boolean[N][N];
            boolean moved = false;
            for(int i = 0 ; i < map.length ; i++) {
                for(int j = 0 ; j < map[i].length ; j++) {
                    if(!visited[i][j]) {
                        if(bfs(i,j)) {
                            moved = true;
                        }
                    }
                }
            }

            // 더 이상 인구이동이 없으면 탈츌
            if(!moved)
                break;
            dayCount++;
        }

        System.out.println(dayCount);
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();  // 연합

        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});

        int sum = map[x][y];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0 ; i < dx.length ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if (L <= diff && diff <= R) {
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                    }
                }
            }
        }

        // 인구이동 끝
        if(union.size() == 1)
            return false;

        int avg = sum / union.size();
        for (int[] pos : union) {
            map[pos[0]][pos[1]] = avg;
        }

        return true;
    }
}
