package baekjoon.java;

import java.util.Scanner;

/**
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 백트래킹: 가능한 모든 경우를 실행해서 정답을 찾는다.
 */
public class N과M1 {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); //3
        int M = scanner.nextInt(); //2

        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0);
        scanner.close();
    }

    public static void dfs(int N, int M, int depth) {
        if ( depth == M ) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}
    
/**
 * 1 2
 * 1 3
 * 2 1
 * 2 3
 * 3 1
 * 3 2
 */