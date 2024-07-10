package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * DP
 */
public class 평범한배낭 {
    static int N, K;
    static int[][] items, dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); 

        items = new int[N+1][2];
        dp = new int[N+1][K+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int k = 1; k < K+1; k++) {
                if (items[i][0] > k) {
                    dp[i][k] = dp[i-1][k];
                } else {
                    dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k - items[i][0]] + items[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }   
}