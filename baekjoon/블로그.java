package baekjoon;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// fail: 시간초과
public class 블로그 {
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
