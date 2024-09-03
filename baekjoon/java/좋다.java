package baekjoon.java;

import java.util.*;
import java.io.*;

public class 좋다 {
    static int N, result;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N-1;

            while(true) {

                if(start == i) start++;
                else if(end == i) end--;

                if(start >= end) break;

                if(array[start] + array[end] == array[i]) {
                    result += 1;
                    break;

                } else if(array[start] + array[end] < array[i]){
                    start ++;
                } else {
                    end--;
                }

            }
        }

        System.out.println(result);

    }
    
}
