package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 패션왕신해빈 {
    static int t, n, result;
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                if (map.containsKey(category)) map.put(category, map.get(category)+1);
                else map.put(category,1);
            }

            result = 1;
            for (int name : map.values()) {
                result *= (name + 1);
            }
            System.out.println(result-1);
        }
    }
}
