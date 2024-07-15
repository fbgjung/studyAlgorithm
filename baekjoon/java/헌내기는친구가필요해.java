package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Queue;

public class 헌내기는친구가필요해 {

    static int n,m,result;
    static char[][] campus;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            campus[i] = str.toCharArray();
            for (int j = 0; j < m; j++) {
                if (campus[i][j] == 'I') queue.offer(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()) {
            int current[] = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && campus[nx][ny] != 'X') {
                    if (campus[nx][ny] == 'P') {
                        result += 1;
                    }
                    campus[nx][ny] = 'X';
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        // 결과 출력 
        if (result == 0) System.out.println("TT");
        else System.out.println(result);
    }
}
