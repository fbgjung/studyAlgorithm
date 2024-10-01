package baekjoon.java;

import java.util.*;
import java.io.*;

public class 상자넣기 {
    static int n, result;
    static int[] box, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        box = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i] > box[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);

    }
    
}
