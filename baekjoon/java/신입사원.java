package baekjoon.java;

import java.util.*;
import java.io.*;

public class 신입사원 {
    static int t, n;
    static int rank[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++ ){
            int result = 1;
            n = Integer.parseInt(br.readLine());

            rank = new int[n+1];

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                rank[a] = b;
            }

            int temp = rank[1];
            for (int r = 2; r <= n; r++) {
                if (rank[r] < temp) {
                    result++;
                    temp = rank[r];
                } 
            }
            System.out.println(result);
        }
    }
}
