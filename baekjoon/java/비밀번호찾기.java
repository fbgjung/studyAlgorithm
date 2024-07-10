package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호찾기 {
    static int n, m;
    static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 16
        m = Integer.parseInt(st.nextToken()); // 4

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String name = st.nextToken();
            map.put(address, name);
        }

        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            System.out.println(map.get(target));
        }
    }
}