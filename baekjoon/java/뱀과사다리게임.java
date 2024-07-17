package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class 뱀과사다리게임 {
    static int n, m;
    static int[] map, game;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[101]; // 사다리와 뱀의 자리를 저장할 배열
        game = new int[101]; // 각 칸 별로 이동 횟수를 저장할 배열
        visited = new boolean[101];

        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        bfs();
    }

    static void bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        game[1] = 0;
        visited[1] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if (cur == 100) {
                System.out.println(game[100]);
                return;
            }

            for (int i = 1; i < 7; i++) {
                int x = cur + i;
                if (x > 100) continue;
                if(visited[x]) continue;
                visited[x] = true;

                if(map[x] != 0) {
                    if(!visited[map[x]]){
                        queue.offer(map[x]); // 사다리나 뱀이 있을 경우, 도착점을 큐에 넣어준다. 
                        visited[map[x]] = true;
                        game[map[x]] = game[cur] + 1; // 도착점에 이동 횟수를 +1 해준다.
                    }
                } else {
                    queue.offer(x);
                    game[x] = game[cur] + 1; // 사다리나 뱀이 없을 경우, 그냥 횟수 + 1 해준다.
                }
            }
        }
    }
}
