package baekjoon.java;

import java.io.*;

/*
 * n이 주어졌을 때, 1부터 n 까지의 수로 이루어진 순열을 사전순으로 출력
 */
public class 모든순열 {
    static int n;
    static int array[]; // 현재까지 만들어진 순열을 저장하는 배열
    static boolean visited[]; // 각 숫자가 이미 순열에 사용되었는지 추적하는 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        visited = new boolean[n];

        dfs(0);
    }

    static void dfs(int count) {
        if (count == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                array[count] = i+1;
                visited[i] = true;
                dfs(count+1);
                visited[i] = false;
            }
        }
    }
}
