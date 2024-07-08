package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += arr[i];
        }

        Arrays.sort(arr);
        int a = 0;
        int b = 0;
        // 두명만 빼서 100이되는지 확인
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if ( i != a && i != b) {
                System.out.println(arr[i]);
            }
        }
    }
}
