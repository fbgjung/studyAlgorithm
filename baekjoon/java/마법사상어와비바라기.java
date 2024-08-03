package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와비바라기 {
    static int N, M, result;
    static int[][] map;
    static int[][] cmd;
    static Queue<Cloud> clouds = new LinkedList<>();

    static int[] dx8 = {0,0,-1,-1,-1,0,1,1,1};
    static int[] dy8 = {0,-1,-1,0,1,1,1,0,-1};

    static int[] dx = {-1,-1,1,1};
    static int[] dy = {-1,1,1,-1};

    static boolean[][] visited;
    public static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        clouds.add(new Cloud(N-1, 0));
        clouds.add(new Cloud(N-1, 1));
        clouds.add(new Cloud(N-2, 0));
        clouds.add(new Cloud(N-2, 1));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // d방향으로
            int s = Integer.parseInt(st.nextToken()); // s만큼이동

            for (Cloud cloud : clouds){

                // (dx8[d] + N) * s : 방향에 따라 이동할 x좌표의 총 거리 (N을 더하여 음수를 양수로 바꾸면서 s 만큼 이동)
                // % N : 구름의 이동이 격자 안에서 이루어지도록 한다.
                cloud.x = (cloud.x + (dx8[d] + N) * s) % N;
                cloud.y = (cloud.y + (dy8[d] + N) * s) % N;
                map[cloud.x][cloud.y]++; // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
            }

            // 3. 구름을 제거하고, 4. 현재 구름이 있는 칸의 대각선에 물이 있는 개수만큼 물의양 증가
            while(!clouds.isEmpty()) {
                Cloud cloud = clouds.poll();
                int cnt = 0;

                visited[cloud.x][cloud.y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = cloud.x + dx[i];
                    int ny = cloud.y + dy[i];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (map[nx][ny] >= 1) {
                            cnt++;
                        }
                    }
                }
                map[cloud.x][cloud.y] += cnt;
            }

            // 5. 구름이 생겼던 칸을 제외한 물의 양이 2 이상인 모든 칸에 구름이 생기고 물의 양이 2 줄어든다.
                // visited 갱신
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] >= 2 && !visited[i][j]) {
                        clouds.add(new Cloud(i, j));
                        map[i][j] -= 2;
                    }
                }
            }

            visited = new boolean[N][N];
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
        
    }
    
}
