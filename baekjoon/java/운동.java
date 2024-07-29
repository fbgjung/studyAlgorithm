package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 운동 {
    static int v, e;
    static int[][] map;
    static final int INF = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new int[v+1][v+1];

        for (int i = 1; i < v+1; i++){
            for (int j = 1; j < v+1; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            st  = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[a][b] = cost;
        }

        for (int k = 1; k < v+1; k++) {
            for (int i = 1; i < v+1; i++) {
                for (int j = 1; j < v+1; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int answer = INF;
        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++){
                if(i != j && map[i][j] != INF && map[j][i] != INF) { // i != j
                    answer = Math.min(answer, map[i][j] + map[j][i]);
                }

            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}
