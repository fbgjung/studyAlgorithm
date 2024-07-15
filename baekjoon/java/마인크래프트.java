package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

/*
 * 제거하여 인벤토리에 넣는다. 2초
 * 인벤토리에서 블록 하나를 꺼내서 블록위에 놓는다. 1초
 */
public class 마인크래프트 {
    static int n, m, b, min, max, minTime;
    static int[][] map;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        max = 0;
        min = 256;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]); 
                min = Math.min(min, map[i][j]); 
            }
        }

        // 출력 변수
        minTime = Integer.MAX_VALUE; // 최소시간
        int height = 0; // 땅의 높이

        for (int i = min; i <= max; i++) {
            int time = 0; 
            int inventory = b;

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (map[x][y] > i) {
                        time += (map[x][y] - i) * 2;
                        inventory += (map[x][y] - i);
                    } else {
                        time += (i - map[x][y]);
                        inventory -= (i - map[x][y]);   
                    }
                }
            }

            if (inventory < 0) break;
            if (time <= minTime) {
                minTime = time;
                height = i;
            }
        }
        System.out.println(minTime + " " + height);
    }
}
