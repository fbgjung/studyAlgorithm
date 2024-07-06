package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * NxN 크기에 사탕을 채워 넣는다.
 * 사탕의 색은 모두 같지 않을 수도 있다.
 * 색이 다른 인접한 두 칸을 고른다.
 * 고른칸에 들어있는 사탕을 서로 교환한다.
 * 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
 * 상근이가 먹을 수 있는 사탕의 최대 개수
 * C 빨, P 파, Z 초, Y 노
 */
public class 사탕게임 {
    static int n, max;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 행을 기준으로 자리바꿈
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == map[i][j-1]) continue;
                change(i, j, i, j-1);
                check(map);
                change(i, j-1, i, j);
            }
        }

        // 열을 기준으로 자리바꿈
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[j-1][i] == map[j][i]) continue;
                change(j-1, i, j, i);
                check(map);
                change(j, i, j-1, i);
            }
        }

        // 결과 출력 
        System.out.println(max);
    }

    static void change(int x1, int y1, int x2, int y2) {
        char a = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = a;
    }

    static void check(char[][] map) {
        // 가장 긴 행 체크
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (map[i][j-1] == map[i][j]) {
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else cnt = 1;
            }
        }

        // 가장 긴 열 체크
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (map[j-1][i] == map[j][i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else cnt = 1;
            }
        }
    }
}
