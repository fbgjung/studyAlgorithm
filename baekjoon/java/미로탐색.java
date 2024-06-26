package baekjoon.java;

import java.util.*;
import java.io.*;

public class 미로탐색 {
    static int n, m, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{startX, startY});

        while(!q.isEmpty()) {
            int current[] = q.poll();
            int y = current[0];
            int x = current[1];
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if ( 0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx]) {
                    if (map[ny][nx] == 1){
                        visited[ny][nx] = true;
                        map[ny][nx] += map[y][x];
                        q.add(new int[] {ny, nx});
                    }
                }
            }
        }
    }
}