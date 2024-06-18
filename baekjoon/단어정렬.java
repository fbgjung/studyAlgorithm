package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로 정렬
 */
public class 단어정렬 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) { // 길이가 같은 경우, 사전 순으로 정렬
                    return s1.compareTo(s2); // compareTo는 사전 순으로 정렬되도록 구현되어있음
                } else {
                    return s1.length() - s2.length(); // 다른 경우, 오름차순 정렬
                    /**
                     * 반환값이 양수일 경우 s1의 길이가 크므로 
                     * 두 요소의 순서응 바꾸어 s1이 뒤에 위치해야 한다.
                     */
                }
            }
        });
        
        // 결과 출력 (중복 제거)
        System.out.println(arr[0]);
        for (int i = 1; i < n; i++) {
            if (!arr[i].equals(arr[i-1])) {
                System.out.println(arr[i]);
            }
        }

    }

}
