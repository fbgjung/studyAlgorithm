package baekjoon.java;

import java.util.*;
import java.io.*;

public class 그림 {
    static int n, m, count;
    static int[][] paper;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    int pictureSize = bfs(i,j);
                    list.add(pictureSize);
                    
                }
            }
        }

        Collections.sort(list);

        if (list.size() == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(list.size());
            System.out.println(list.get(list.size()-1));
        }
        
    }

    static int bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    if (paper[nx][ny] == 1) {
                        count++;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return count;
    }
}
