package baekjoon;

import java.util.Scanner;

public class 꿀아르바이트 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long term = 0;
        long result = 0;

        for (int i = 0; i < m; i++){
            term += arr[i];
        }
        result = term;

        for (int i = m; i < n; i++) {
            term += arr[i] - arr[i-m];
            result = Math.max(result, term);
        }
        System.out.println(result);

        scanner.close();
    }
    
}
