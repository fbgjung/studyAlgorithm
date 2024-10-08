package baekjoon.java;

import java.util.*;
import java.io.*;

public class 리모컨 {
    static int n, m;
    static boolean[] isButtonBroken;
    static int minClick = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        isButtonBroken = new boolean[10];

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int button = Integer.parseInt(st.nextToken());
                isButtonBroken[button] = true;
            }
        }
        
        // 1. n = 100
        if (n == 100) {
            System.out.println(0);
            return;
        }
    
        // 2. n에서 +/- 만으로 가는 경우
        minClick = Math.abs(n - 100);

        // 3. n의 근사치 번호까지 누른 다음 +/-를 이용하여 가는 경우
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            if (check(str)) {
                int currentPress = str.length() + Math.abs(n - i);
                minClick = Math.min(currentPress, minClick);
            }
        }
        System.out.println(minClick);

    }

    // 고장나지 않은 버튼으로 구성되어있는지 확인
    static boolean check(String str) {
        char[] charList = str.toCharArray();
        for (char c : charList) {
            if (isButtonBroken[c-'0']) {
                return false;
            }
        }
        return true;
    }
    
}
