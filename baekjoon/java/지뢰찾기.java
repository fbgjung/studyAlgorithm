package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지뢰찾기 {
    static int N, result;
    static char map[][];
    static int dx[] = {-1,-1,-1,0,0,1,1,1};
    static int dy[] = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(map[i][j])) {
                    int cnt = map[i][j] - '0';
                    find(i, j, cnt);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*' || map[i][j] == '#') {
                    result += 1;
                }
             }
        }
        System.out.println(result);
    }

    public static void find(int x, int y, int cnt) {
        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (map[nx][ny] == '#' && cnt != 0) {
                    map[nx][ny] = '*';
                    cnt--;
                } else if(map[nx][ny] == '*' && cnt != 0) {
                    cnt--;
                } else if(map[nx][ny] == '#' && cnt == 0) {
                    map[nx][ny] = 'X';
                }
               
            }
        }
    }
    
}
