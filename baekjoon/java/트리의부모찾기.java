package baekjoon.java;

import java.io.*;  
import java.util.*;  
  
public class 트리의부모찾기 {  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;  

        int N = Integer.parseInt(br.readLine());  
        int[] parent = new int[N + 1];  
        ArrayList<Integer>[] list = new ArrayList[N + 1];  
        
        for (int i = 1; i <= N; i++) {  
            list[i] = new ArrayList<>();  
        }  
        
        boolean[] visited = new boolean[N + 1];  
        
        for (int i = 1; i < N; i++) {  
            st = new StringTokenizer(br.readLine());  
            int a = Integer.parseInt(st.nextToken());  
            int b = Integer.parseInt(st.nextToken());  
            list[a].add(b);  
            list[b].add(a);  
        }  
  
        Queue<Integer> queue = new LinkedList<>();  
        queue.add(1);  
        visited[1] = true;  
        
        // BFS   
        while (!queue.isEmpty()) {  
            int current = queue.poll();  
            for (int next : list[current]) {  
                if (visited[next]) {  
                    continue;  
                }  
                visited[next] = true;  
                queue.add(next);  
                parent[next] = current;  
            }  
        }  
        
        for (int i = 2; i <= N; i++) {  
            System.out.println(parent[i]);  
        }  
    }  
}