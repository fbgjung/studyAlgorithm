package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 이분탐색 + LIS
 */
public class 반도체설계_2 {
    static int N;
    static int[] semi, lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        semi = new int[N];
        lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            semi[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = semi[0];
        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (lis[idx] < semi[i]) {
                // 새로운 최대값이 나오면, lis에 끝에 추가
                lis[++idx] = semi[i];
            } else {
                // 이분탐색으로 semi[i]이 들어갈 자리를 찾는다.(대체)
                int temp = binarySearch(0, idx, semi[i]);
                lis[temp] = semi[i];
                
            }
        }
        System.out.println(idx +1);

    }

    public static int binarySearch(int start, int end, int target) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(lis[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        
        }
        return start;
    }
}
