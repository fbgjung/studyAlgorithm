package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 뱀 {
    static int[][] map;
    static List<int[]> snake = new ArrayList<>(); // 뱀이 차지한 칸
    static int N, K, L;
    static HashMap<Integer, String> cmd = new HashMap<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0}; // 동남서북

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for (int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            cmd.put(time, str);   
        }

        int currentX = 1, currentY = 1;
        int time = 0;
        int d = 0;

        snake.add(new int[]{1,1});

        while(true) {
            time++;

            int nx = currentX + dx[d];
            int ny = currentY + dy[d];

            if (nx <= 0 || ny <= 0 || nx > N || ny > N) break;

            for (int i = 0; i < snake.size(); i++){
                int[] temp = snake.get(i);
                if (temp[0] == nx && temp[1] == ny) {
                    System.out.println(time);
                    return;
                }

            }

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new int[]{nx, ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            if (cmd.containsKey(time)){
                if(cmd.get(time).equals("D")) {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
            }

            currentX = nx;
            currentY = ny;

        }
        System.out.println(time);
    }   
}
