import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
 * 아무 규칙없이 나열되어 있는 숫자중 범위를 정한 후 무조건 오름차순으로 정리
 * 오름차순으로 정리된 숫자 중 k 번째 숫자를 선택한다.
 * 배열 a가 주어지고, K씨가 일을 한 횟수가 주어졌을 때, K씨가 고른 숫자를 출력하는 프로그램
 */
public class 정리정돈을좋아하는K씨 {
    static int n, m; // 배열의 크기, K씨가 일한 횟수
    static int[] arr,temp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // K 씨가 일한 m만큼 반복
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int target = Integer.parseInt(st.nextToken());
            int size = end - start + 1;

            temp = new int[size];
            for (int j = 0; j < size; j++) {
                temp[j] = arr[start++];
            }

            Arrays.sort(temp);
            
            for (int k = 0; k < size; k ++) {
                if (k == target-1) System.out.println(temp[k]);
            }   
        }
    }
}