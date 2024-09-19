package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class 회전하는큐 {
    static int N, M, result;
    static LinkedList<Integer> numbersList = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N+1; i++) {
            numbersList.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());

            int target = numbersList.indexOf(number);
            int half = numbersList.size() / 2;

            if (target <= half) { // target 숫자가 절반보다 작다면 왼쪽으로 값을 빼냄
                while(number != numbersList.getFirst()) {
                    numbersList.add(numbersList.removeFirst()); // 가장 왼쪽 값 제거후 리스트 오른쪽에 추가
                    result++;
                }
            } else { // 아니라면 오른쪽으로 값을 빼냄
                while(number != numbersList.getFirst()) {
                    numbersList.addFirst(numbersList.removeLast()); // 가장 오른쪽 값 제거후 리스트 왼쪽에 추가
                    result++;
                }
            }

            numbersList.removeFirst(); // target 숫자 삭제

        }
        System.out.println(result);
  
    }
}
