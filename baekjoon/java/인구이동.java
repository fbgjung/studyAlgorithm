package baekjoon.java;

import java.io.*;
import java.util.*;

public class 인구이동 {
    static int N, L, R, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<int[]> list; // 연합 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
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

        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]){
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            change(sum);
                            isMove = true;
                        }

                    } 
                }
            }
            if (!isMove) break;
            result++;
        }

        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        list = new ArrayList<>(); // 연합 리스트 초기화

        queue.offer(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = map[x][y];
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[current[0]][current[1]] - map[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.offer(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                    }
                }
            }
        }
        return sum;
    }

    public static void change(int sum) {
        int avg = sum / list.size();
        for (int[] l : list) {
            map[l[0]][l[1]] = avg;
        }
    }   
}
