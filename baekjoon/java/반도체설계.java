package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n개의 포트가 다른 n개의 포트와 어떻게 연결되어야 하는지 주어졌을 때,
 * 연결선이 서로 꼬이지 않도록 하면서 최대 몇 개까지 연결할 수 있는지 알아내는 문제
 * 
 * 최대 40000개의 포트 -> 시간복잡도를 O(NlogN)으로 줄여야한다.
 * 1번 포트와 연결되어야 하는 포트 번호, 2번 포트와 연결되어야 하는 포트번호, ... , n번 포트와 연결되어야 하는 포트 번호가 주어진다.
 * 이 수들은 1이상 n이하이며 서로 같은 수는 없다고 가정
 */
public class 반도체설계 {
    static int N;
    static int[] semi, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        semi = new int[N];
        dp = new int[N];

        // 이미 A 포트는 정렬이 되어있는 상태
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            semi[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (semi[i] > semi[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 1;
        for (int d : dp) {
            max = Math.max(max, d);
        }
        System.out.println(max);
        
    }
    
}
