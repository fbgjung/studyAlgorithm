package baekjoon.java;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;
        

        while (N > 0){
            if (N % 5 == 0) {
                result += N/5;
                N = N % 5;
            } else {
                N -= 3;
                result += 1;
            }  
            if (N < 0) {
                result = -1;
            }
        }
        System.out.println(result);
        scanner.close();
    } 
}
