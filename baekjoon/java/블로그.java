package baekjoon.java;

import java.util.StringTokenizer;
import java.util.List;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStreamReader;

// fail: 시간초과
/**
class 블로그fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int arr[] = new int[N];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int maxVisit = 0;

        for (int i = 0; i < N-X+1; i++) {
            for (int j = i; j < i+X; j++) {
                maxVisit += arr[j];
                
            }
            list.add(maxVisit);
            maxVisit = 0;
        }

        Collections.sort(list); // 리스트 정렬
        int result = list.get(list.size()-1);
        int count = Collections.frequency(list, result);

        if (result == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(result);
            System.out.println(count);
        }

    }
}
*/


// 슬라이딩윈도우 알고리즘 활용
public class 블로그 {
    public static void main(String[] args) throws Exception{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int count = 0;
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int term = 0;
        int result = 0;

        for (int i = 0; i < K; i++) {
            term += arr[i];
        }

        result = term;
        list.add(result);
        for (int i = K; i < N; i++) {
            term += arr[i] - arr[i-K];
            list.add(term);
            result = Math.max(result, term);
            
        }
        if (result == 0) {
            System.out.println("SAD");
            return;
        } else {
            count = Collections.frequency(list, result);
            System.out.println(result);
            System.out.println(count);
        }
        // System.out.println(list);
    }
}
