package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {
    static int n, m;
    static int[][] map;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                map[i][j] = INF;
                if (i == j) map[i][j] = 0;
            }
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 시작 도시와 도착 도시를 연결하는 노선을 하나가 아닐 수 있다.
            map[a][b] = Math.min(map[a][b], cost);
        }

        for (int k = 1; k < n+1; k++){
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (map[i][j] == INF) sb.append("0 ");
                else sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
