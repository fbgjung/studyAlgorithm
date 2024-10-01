package baekjoon.java;

import java.util.*;
import java.io.*;

public class 차이를최대로 {
    static int n, result;
    static int[] array;
    static int[] temp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        array = new int[n];
        temp = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);

    }

    static void dfs(int count){
        if(count == n) {
            int sum = 0; 
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(temp[i] - temp[i+1]);
            }
            result = Math.max(sum, result);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                temp[count] = array[i];
                visited[i] = true;
                dfs(count+1);
                visited[i] = false;

            }
        }
    }
    
}
