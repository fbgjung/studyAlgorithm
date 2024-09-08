package baekjoon.java;

import java.io.*;
import java.util.*;

public class 치즈 {

    static int n, m, time, cheese; // 세로, 가로, (치즈 녹는 시간, 모두 녹기 한 시간 전에 남아있는 칸의수)
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Integer> countCheese = new ArrayList<>(); // 시간마다 남은 치즈 개수 정보 보관

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int initCheese = countCheese();

        while(flag) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
        
            time++;
            bfs(0,0); // 치즈 녹이기
           
            int count = countCheese(); // 남은 치즈 개수 count    

            if(count == 0) {
                flag = false;
            } else {
                countCheese.add(count);
            }
        }

        // 결과 출력
        System.out.println(time); 
        
        if (countCheese.size() > 0) {
            cheese = countCheese.get(countCheese.size()-1);
            System.out.println(cheese);
        } else {
            cheese = initCheese;
            System.out.println(cheese);
        }
    }

    public static void bfs(int x, int y) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }
                    if (board[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny}); 
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m;  j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int countCheese() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
}
