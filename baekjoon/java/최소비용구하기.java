package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/*
 * N개의 도시
 * 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다.
 * A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화하는 문제 
 * 인접리스트
 */

class Vertex implements Comparable<Vertex> {
    int b;
    int cost;
    public Vertex(int b, int cost) {
        this.b = b;
        this.cost = cost;
    }

    @Override
    // 큐에서 요소를 제거하면, 비용이 가장 작은 Vertex 객체가 제거
    public int compareTo(Vertex o) {
        return cost - o.cost;
    }
}

public class 최소비용구하기 {
    static int n, m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 각 인덱스에 해당하는 정점까지의 최소거리를 저장하는 리스트 
        int[] min_dist = new int[n+1];
        Arrays.fill(min_dist, Integer.MAX_VALUE);

        // 인접리스트
        ArrayList<ArrayList<Vertex>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Vertex(b, cost));
        }

        // 구하고자 하는 구간 출발점의 도시번화와 도착점의 도시번호
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(n, min_dist, adj, start, end));
    }

    public static int dijkstra(int n, int[] min_dist, ArrayList<ArrayList<Vertex>> adj, int start, int end) {
        // 가장 짧은 거리를 구하기 위한 정렬이 항상 이루어져야 하므로 우선순위 큐를 사용
        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];

        q.offer(new Vertex(start,0));
        min_dist[start] = 0; // 시작정점은 거리 0으로 초기화

        while(!q.isEmpty()) {
            Vertex current = q.poll();
            int b = current.b;
            int cost = current.cost;

            if (b == end) {
                return cost;
            }

            // 방문하지 않은 정점 
            if (!visited[b]) {
                visited[b] = true;
                // 해당 정점과 연결된 정점들에 대해
                for (Vertex vertex : adj.get(b)) {
                    int new_cost = cost + vertex.cost;

                    if (new_cost < min_dist[vertex.b]) {
                        min_dist[vertex.b] = new_cost;
                        q.offer(new Vertex(vertex.b, new_cost));

                    }
                }
            }
        }
        
        return min_dist[end];
    }
    
}
