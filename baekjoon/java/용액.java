package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
    static int n, first, second;
    static int min = Integer.MAX_VALUE;
    static int array[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;

        while(left < right){
            int sum = array[left] + array[right];

            int temp = Math.abs(sum);

            if(temp < min) {
                min = temp;
                first = array[left];
                second = array[right];
            }
            
            if(sum > 0) right--;
            else left++;
        }   
        
        System.out.println(first + " " + second);

    }
    
}
