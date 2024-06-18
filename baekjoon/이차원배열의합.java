package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이차원배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        int[][] arr = new int[N][M];
 
        for (int i = 0 ; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0])-1;
            int b = Integer.parseInt(temp[1])-1;
            int c = Integer.parseInt(temp[2])-1;
            int d = Integer.parseInt(temp[3])-1;
            int sum = 0;
            for (int j = a; j <= c; j++) {
                for (int k = b; k <= d; k++) {
                    sum += arr[j][k];
                }
            }
            System.out.println(sum);

        }

    }
    
}
