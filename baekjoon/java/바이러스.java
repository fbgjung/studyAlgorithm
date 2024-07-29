package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
    static int n,m,result;
    static boolean[] visited;
    static int[][] map;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0 ; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(1);
        System.out.println(result-1);
    }

    public static void dfs(int x) {
        visited[x] = true;
        result += 1;

        for (int i = 1; i <= n; i++) {
            if (map[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
