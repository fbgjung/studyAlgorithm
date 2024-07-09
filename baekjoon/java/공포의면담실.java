package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
 * N개의 부서가 있다.
 * 부서에 소속된 모든 직원이 모두 면담을 마쳐야 해당 부서가 퇴근할 수 있다.
 * 면담은 한번에 한명씩만
 * 모든 부서의 퇴근 시간의 합이 최소가 되는 값
 */
public class 공포의면담실 {
    static int n;
    static long result;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                arr[i] += Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i-1];            
        }
        for (int a : arr) {
            result += a;
        }
        System.out.println(result);        
    }
}
