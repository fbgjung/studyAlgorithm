package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        
        for (int i = 0; i < N; i++) {

            boolean visited[] = new boolean[26];
            String word = br.readLine();
            char[] c = word.toCharArray();
            visited[c[0]-'a'] = true; 
            boolean isGroupWord = true;
            
            for (int j = 1; j < c.length; j++) {
                if (c[j] != c[j-1] && visited[c[j]-'a']) {
                    isGroupWord = false;
                    break;
                }
                visited[c[j]-'a'] = true;
            }
            if(isGroupWord) result++;
            

        }
        System.out.println(result);
    }
    
}
