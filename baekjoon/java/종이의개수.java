package baekjoon.java;

import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class 종이의개수 {
    static int[][] map;
    static int a = 0;
    static int b = 0;
    static int c = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(0,0,n);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    static void paper(int y, int x, int size) {
        
        if (check(y, x, size)) {
            if (map[y][x] == -1) a++;
            else if (map[y][x] == 0) b++;
            else c++;
            return; 
        }

        int newSize = size / 3; 
        paper(y, x, newSize);
        paper(y, x + newSize, newSize);
        paper(y, x + (newSize * 2), newSize);
        paper(y + newSize, x, newSize);
        paper(y + newSize, x + newSize, newSize);
        paper(y + newSize, x + (newSize * 2), newSize);
        paper(y + (newSize * 2), x, newSize);
        paper(y + (newSize * 2), x + newSize, newSize);
        paper(y + (newSize * 2), x + (newSize * 2), newSize);
    }

    static boolean check (int y, int x, int size) {
        int v = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(map[i][j] != v) return false;
            }
        }
        return true;
    }

}
