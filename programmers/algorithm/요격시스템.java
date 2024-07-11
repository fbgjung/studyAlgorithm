import java.util.Arrays;

/*
 * 모든 폭격 미사일을 요격하기 위해 필요한 요격 미사일 수의 최솟값을 return 
 */
public class 요격시스템 {
    static int answer;
    public static void main(String[] args) {
        int[][] targets = {
            {4, 5},
            {4, 8},
            {10, 14},
            {11, 13},
            {5, 12},
            {3, 7},
            {1, 4}
        };
        int result = solution(targets);
        System.out.println(result);
    }

    static int solution(int[][] targets) {
        Arrays.sort(targets, (r1, r2) -> {
            if (r1[1] == r2[1]) {
                return r1[0] - r2[0];
            }
            return r1[1] - r2[1];
        });

        int last = targets[0][1];
        answer = 1;

        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= last) {
                last = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}
