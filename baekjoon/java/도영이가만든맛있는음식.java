package baekjoon.java;

import java.util.*;
import java.io.*;

public class 도영이가만든맛있는음식 {
    static int n;
    static int[] sour; // *
    static int[] bitter;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        sour = new int[n];
        bitter = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,1,0,0);
        System.out.println(result);

    }

    static void dfs(int depth, int s, int b, int selectedCount) {
        if (depth == n) {
            if (selectedCount != 0 && Math.abs(s-b) < result){
                result = Math.abs(s-b);
            }
            return;
        }
        dfs(depth+1, s*sour[depth], b+bitter[depth], selectedCount+1); // 재료 선택
        dfs(depth+1, s, b, selectedCount); // 재료 비선택

    }
    
}
