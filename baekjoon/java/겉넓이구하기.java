package baekjoon.java;

import java.io.*;
import java.util.*;

public class 겉넓이구하기 {
    static int n, m, result, temp;
    static int[][] array;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result += (n * m) * 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (array[nx][ny] < array[i][j]) {
                            result += array[i][j] - array[nx][ny];
                        }
                    } else {
                        result += array[i][j];
                    }
                }
            }
        }
        System.out.println(result);
    }
    
}