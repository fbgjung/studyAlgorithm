package baekjoon.java;

import java.util.*;
import java.io.*;

public class 다리만들기 {

    static int n;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int idx = 2;
    static int minBridge = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    sep(i, j, idx++);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 1) {
                    visited = new boolean[n][n];
                    bridge(i, j, map[i][j]);
                }
            }
        }

        System.out.println(minBridge);
    }

    public static void sep(int x, int y, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = idx;    

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = idx;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }


    public static void bridge(int x, int y, int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();   
            int bridgeLength = current[2];         

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny, bridgeLength+1});
                    } else if (map[nx][ny] != index) {
                        minBridge = Math.min(minBridge, bridgeLength);
                        return;
                    }
                }
            }
        }
    }
}