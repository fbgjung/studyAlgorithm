package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {
    static int tree_number, tree_length;
    static int[] trees;
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tree_number = Integer.parseInt(st.nextToken());
        tree_length = Integer.parseInt(st.nextToken());

        trees = new int[tree_number];

        int start = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < tree_number; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            if(max < trees[i]){
                max = trees[i];
            }
        }

        while(start < max) {
            int mid = (start + max) / 2;
            
            long total = 0;
            for (int tree : trees){
                if(tree > mid) {
                    total += (tree - mid);
                }
            }

            if(total >=  tree_length){
                start = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(start-1);
    }
}