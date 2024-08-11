package baekjoon.java;

import java.io.*;
import java.util.*;

/*
 * 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때
 * 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수
 * 
 * 같은 위치에 두 개 이상의 전깃줄이 연결 될 수 없다.
 * 
 * 전체 전선 개수 - 설치 가능한 최대 개수
 */
public class 전깃줄 {
    static int N;
    static int[][] wire;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        wire = new int[N][2];
        dp = new int[N];
        

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        // A 전봇대를 기준으로 정렬
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[]o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (wire[i][1] > wire[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 1;
        for (int d : dp) {
            max = Math.max(d, max);
        }

        System.out.println(N-max);
    }
    
}
