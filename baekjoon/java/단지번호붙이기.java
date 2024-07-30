package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class 단지번호붙이기 {
    static int[][] graph;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine().trim());
        graph = new int[n][n];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0 ; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    list.add(bfs(i,j));
                } else continue;
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int l : list) {
            System.out.println(l);
        }
    }

    public static int bfs(int x, int y) {
        int count = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y}); 
        graph[x][y] = 2;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentx = current[0];
            int currenty = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + currentx;
                int ny = dy[i] + currenty;

                if (0 <= nx && nx < n && 0 <= ny && ny < n && graph[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    graph[nx][ny] = 2;
                    count++;
                }
            }
        }
        
        return count;
    }
}