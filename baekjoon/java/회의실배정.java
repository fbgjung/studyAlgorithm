package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
 */
public class 회의실배정 {
    static int n, result;
    static int[][] rooms;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        rooms = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료시간 오름차순
        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] r1, int[] r2) {
                // 종료시간이 같을 경우 시작 시간이 빠른순으로 정렬
                if(r1[1] == r2[1]) {
                    return r1[0] - r2[0];
                }
                return r1[1] - r2[1];
            }
        });

        result = 1;
        int last = rooms[0][1];

        // 최대 회의 개수 구하기
        for (int i = 1; i < n; i++) {
            if (rooms[i][0] < last) continue; // 그 다음 회의 시작시간이 이전 회의 종료시간보다 작으면 패스
            result+=1;
            last = rooms[i][1];
        }
        System.out.println(result);
    }
}
