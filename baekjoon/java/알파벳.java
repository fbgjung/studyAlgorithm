package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
    static int R, C, result;
    static char[][] map;
    static boolean[] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); 
        map = new char[R][C];

        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        dfs(0, 0, 1);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int count) {
        visited[map[x][y] - 'A'] = true;

        result = Math.max(result, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[map[nx][ny] - 'A']) {
                dfs(nx, ny, count + 1);
            }
        }

        // 백트래킹
        visited[map[x][y] - 'A'] = false;
    }
}
