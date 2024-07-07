package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1~49 에서 6개를 고른다.
 * k 개의 수를 골라 집합 S를 만든다음 그 수만 가지고 번호를 선택한다.
 * k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다
 * 집합 S와 K
 * 수를 고르는 모든 방법을 구하는 프로그램
 * 
 * 입력의 마지막 줄에는 0이 하나 주어진다.
 */
public class 로또 {
    static int[] numbers;
    static int[] targets = new int[6];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            int k = Integer.parseInt(st.nextToken()); // 첫번째는 k
            if (k == 0) break; // 0 입력시 종료 

            numbers = new int[k];
            
            for (int i = 0; i < k; i++){ // 1 2 3 4 5 6 7
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 7개 중에서 6개를 선택하는 순열을 출력해야 한다. 
            comb(0,0);
            System.out.println();
        }
    }
    // 모든 가능한 조합
    static void comb(int numbersIdx, int targetIdx) {
        if (targetIdx == targets.length) {
            for (int i = 0; i < 6; i++) {
                System.out.print(targets[i] + " ");
            }
            System.out.println();
            return;
        }

        if (numbersIdx ==  numbers.length) return;

        targets[targetIdx] = numbers[numbersIdx];

        comb(numbersIdx + 1, targetIdx + 1); // 현재 숫자를 포함하는 경우
        comb(numbersIdx + 1, targetIdx); // 현재 숫자를 포함하지 않는 경우
    }
}
