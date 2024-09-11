package baekjoon.java;

import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {
    static int n;
    static int[] numbers;
    static int[] op;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, numbers[0], op[0], op[1], op[2], op[3]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void backtracking(int d, int total, int plus, int minus, int multiple, int divide) {

        if (d == n) {
            min = Math.min(total, min);
            max = Math.max(total, max);
            return;
        }

        if (plus > 0) {
            backtracking(d + 1, total + numbers[d], plus - 1, minus, multiple, divide);
        }
        if (minus > 0) {
            backtracking(d + 1, total - numbers[d], plus, minus - 1, multiple, divide);
        }
        if (multiple > 0) {
            backtracking(d + 1, total * numbers[d], plus, minus, multiple - 1, divide);
        }
        if (divide > 0) {
            backtracking(d + 1, total / numbers[d], plus, minus, multiple, divide - 1);
        }
    }
    
}
