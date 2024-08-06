package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 두개의 숫자로 이루어진 연속된 배열의 가장 긴 길이를 찾는다.
 */
public class 과일탕후루 {
    static int N, max;
    static int[] fruits;
    static int[] visited = new int[10];;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, count = 0;
        
        while(right < N){
            if (visited[fruits[right]] == 0) {
                count++;
            }
            visited[fruits[right]]++;
            right++;

            while (count > 2) {
                visited[fruits[left]]--;
                if (visited[fruits[left]] == 0) {
                    count--;
                }                
                left++;
            }

            max = Math.max(max, right-left);
        }
        System.out.println(max);
    }
}

/*
기존 visited를 boolean으로 했을 때 반례 (로직 자체가 틀렸음)
10
7 5 5 2 4 2 2 5 5 5
 */