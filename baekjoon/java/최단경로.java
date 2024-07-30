package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 주어진 시작점에서의 모든 정점까지의 최단경로
 */

class Vertex implements Comparable<Vertex> {
    int b;
    int cost;
    public Vertex(int b, int cost) {
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Vertex o) {
        return cost - o.cost;
    }
}

public class 최단경로 {
    static int v,e,start;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Vertex>> adj = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Vertex(b, cost));   
        }

        int[] min_dist = new int[v+1];
        Arrays.fill(min_dist, INF);

        dijkstra(start, min_dist, adj);

        for (int i = 1; i < v + 1; i++) {
            if (min_dist[i] == INF) System.out.println("INF");
            else System.out.println(min_dist[i]);
        }
        
    }

    public static void dijkstra(int start, int[] min_dist, ArrayList<ArrayList<Vertex>> adj){
        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[v+1];

        q.offer(new Vertex(start, 0));
        min_dist[start] = 0;

        while(!q.isEmpty()) {
            Vertex current = q.poll();
            int b = current.b;
            int cost = current.cost;

            if (!visited[b]) {
                visited[b] = true;
                for (Vertex vertex : adj.get(b)) {
                    int new_cost = cost + vertex.cost;

                    if (new_cost < min_dist[vertex.b]) {
                        min_dist[vertex.b] = new_cost;
                        q.offer(new Vertex(vertex.b, new_cost));
                    }

                }
            }
        }
    }
}
