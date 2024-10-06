package baekjoon.java;

import java.util.*;
import java.io.*;

public class 최소스패닝트리_크루스칼 {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;
        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int v, e;
    static int[] parents;
    static ArrayList<Node> nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parents = new int[v+1];
        nodeList = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList.add(new Node(from, to, cost));
        }

        Collections.sort(nodeList);

        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        int sum = 0;
        int cnt = 0;

		for(Node n : nodeList) {
			if(union(n.from, n.to)) {
				sum += n.cost;
				cnt++;
				
				if(cnt == v - 1) break;
			}
		}
		
		System.out.println(sum);

    }

	private static boolean union(int from, int to) {
		int fromRoot = findSet(from);
		int toRoot = findSet(to);
		
		if(fromRoot == toRoot) return false;
		
		else parents[toRoot] = fromRoot;
		return true;
	}

	private static int findSet(int v) {
		if(parents[v] == v) return v;
		else return parents[v] = findSet(parents[v]);
	}

}

/*
3 3
1 2 1
2 3 2
1 3 3

3
 */