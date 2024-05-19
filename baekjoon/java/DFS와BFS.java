package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.Queue;

public class DFS와BFS {
    static int node, line, start;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken()); // 노드 개수
        line = Integer.parseInt(st.nextToken()); // 간선 개수
        start = Integer.parseInt(st.nextToken()); // 시작 번호

        // 인접 행렬 생성
        arr = new int[node+1][node+1];
       
        for (int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[node+1];
        dfs(start);

        System.out.println();

        visited = new boolean[node+1];
        bfs(start);
        
        /**
         * [0, 0, 0, 0, 0]
            [0, 0, 1, 1, 1]
            [0, 1, 0, 0, 1]
            [0, 1, 0, 0, 1]
            [0, 1, 1, 1, 0]
         */
    
        

        // for (int a[] : arr) {
        //     System.out.println(Arrays.toString(a));
        // }
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        if(start == arr.length){
            return;
        }

        for (int j = 1; j < arr.length; j++){
            if(arr[start][j] == 1 && visited[j] == false){
                dfs(j);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for (int j = 1; j < arr.length; j++){
                if(arr[temp][j] == 1 && visited[j] == false) {
                    queue.add(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}