package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거짓말 {
    static int N, M, result;
    static int[][] map;
    static boolean[] visited;
    static int[] peopleWhoKnow;
    static Queue<Node> queue = new LinkedList<>();

    public static class Node {
        int person;
        int party;

        public Node(int person, int party) {
            this.person = person;
            this.party = party;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        map = new int[N+1][M+1]; // 사람 x 파티
        visited = new boolean[M+1]; // 파티에서 거짓말 해도되는지 여부
        Arrays.fill(visited, false);
        
        // 비밀을 알고 있는 사람
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        peopleWhoKnow = new int[num];
        for (int i= 0; i < num; i++) {
            peopleWhoKnow[i] = Integer.parseInt(st.nextToken());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int i = 0; i < size; i++) {
                int p = Integer.parseInt(st.nextToken());                
                map[p][m+1] = 1;
            }
        }

        for (int p : peopleWhoKnow){
            for (int j = 1; j < M+1; j++) {
                if (map[p][j] == 1) {
                    queue.add(new Node(p, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int person = node.person;
            int party = node.party;

            if(visited[party]) continue;
            visited[party] = true;

            for (int i = 1; i < N + 1; i++) {
                if (map[i][party] == 1) {
                    for (int j = 1; j < M+1; j++) {
                        if (map[i][j] == 1 && !visited[j]) {
                            queue.add(new Node(i, j));
                        }
                    }
                }
            }
        }

        for (int i = 1; i < M+1; i++) {
            if (!visited[i]) result++;
        }
        System.out.println(result);
    }
}
