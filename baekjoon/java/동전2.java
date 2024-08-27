package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 동전2 {
    static int N, K;
    static int[] coins, dp;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 동전의 개수
        K = Integer.parseInt(st.nextToken()); // 가치의 합

        coins = new int[N+1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            coins[i] = Integer.parseInt(str);
        }

        dp = new int[K+1];
        
        Arrays.sort(coins);
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for (int i = 0 ;i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1 );
            }
        }

        int result = dp[K] == Integer.MAX_VALUE-1 ? -1 : dp[K];
        System.out.println(result);
        
    }
}
