package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치킨TOPN {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        int split = N / K;
    
        for (int i = 0 ; i < N; i += split) {
            top(i, i + split);
        }
        System.out.println(sb);
    }

    private static void top(int start, int end) {
        int[] temp = new int[end-start];

        for (int i = start; i < end; i++) {
            temp[i - start] = arr[i];
        }

        Arrays.sort(temp);
        
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]).append(" ");
        }
    }
}
