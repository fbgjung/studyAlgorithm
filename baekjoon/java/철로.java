package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 집과 사무실 위치가 모두 그 선분에 포함되는 사람들의 최대 수를 출력
 */
public class 철로 {

    static class Data implements Comparable<Data> {
        int a, b;
        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Data o) {
            if (b == o.b) return a - o.a;
            return b - o.b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Data> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Data(Math.min(a, b), Math.max(a, b)));
        }

        int d = Integer.parseInt(br.readLine());

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;

        for(int i=0;i<N;i++){
            Data data = list.get(i);

            if (data.b - data.a > d) continue;
            pq.add(data.a);

            while (!pq.isEmpty()) {
                if (data.b - pq.peek() <= d) break;
                pq.poll();
            }

            result = Math.max(result, pq.size());
        
        }
    System.out.println(result);}
}
