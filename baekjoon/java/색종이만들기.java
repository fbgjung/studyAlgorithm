package baekjoon.java;

import java.util.*;
import java.io.*;

public class 색종이만들기 {
    static int n, blue, white;
    static int[][] paper;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 2, 4, 8, 16, 32, 64, 128
        

        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);
        
        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int y, int x, int n) {
        if ( check(y, x, n) ){
            if (paper[y][x] == 1) blue++;
            else white++;
            return;
        }

        int half = n / 2;
        divide(y, x, half);
        divide(y, x + half, half);
        divide(y + half, x, half);
        divide(y + half, x + half, half);
        
    }

    static boolean check(int y, int x, int n) {
        int ch = paper[y][x];

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (ch != paper[i][j]) return false;
            }
        }
        return true;
    }
}
