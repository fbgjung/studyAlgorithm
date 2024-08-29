package baekjoon.java;

import java.util.*;
import java.io.*;

public class DNA비밀번호 {
    static int s, p, result;
    static int[] input; 
    static int[] minCount;
    static int[] currentCount;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        s  = Integer.parseInt(st.nextToken());
        p  = Integer.parseInt(st.nextToken());

        String inputStr = br.readLine();
        char[] c = inputStr.toCharArray();

        minCount = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(st.nextToken());
        }

        currentCount = new int[4];
        
        for (int i = 0; i < p; i++) {
            char temp = c[i];
            switch(temp) {
                case 'A': currentCount[0]++; break;
                case 'C': currentCount[1]++; break;
                case 'G': currentCount[2]++; break;
                case 'T': currentCount[3]++; break;
            }
        }

        if (checkValid()) {
            result++;
        }

        for (int i = p; i < s; i++) {
            switch(c[i]) {
                case 'A': currentCount[0]++; break;
                case 'C': currentCount[1]++; break;
                case 'G': currentCount[2]++; break;
                case 'T': currentCount[3]++; break;
            }

            switch(c[i-p]) {
                case 'A': currentCount[0]--; break;
                case 'C': currentCount[1]--; break;
                case 'G': currentCount[2]--; break;
                case 'T': currentCount[3]--; break;
            }

            if (checkValid()) {
                result++;
            }
        }

        System.out.println(result);
        
    }

    private static boolean checkValid() {
        for (int i = 0; i < 4; i++) {
            if (currentCount[i] < minCount[i]) {
                return false;
            }
        }
        return true;

    }
}
