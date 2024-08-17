package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산 {
    static int N, M, result;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            int check = check();
            if (check > 1) {
                break;
            }
            if (check == 0) {
                result = 0;
                break;
            }
            melt();
            result++;
        }
        System.out.println(result);
        
    }

    // 빙하 개수 체크
    public static int check() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (map[nx][ny] != 0 && !visited[nx][ny]) {
                    dfs(nx, ny, visited);
                }
            }
        }
    }

    // 빙하 녹이기
    public static void melt() {
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int sea = 0;

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        sea++;
                    }
                }
            }

            // 갱신
            if (map[current[0]][current[1]] - sea < 0) {
                map[current[0]][current[1]] = 0;
            } else {
                map[current[0]][current[1]] -= sea;
            }
        }
    }
    
}
