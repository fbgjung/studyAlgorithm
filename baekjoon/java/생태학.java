package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class 생태학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        String input = br.readLine();

        while(true) {
            result++;
            map.put(input, map.getOrDefault(input, 0)+1);

            input = br.readLine();
            if(input == null || input.length() == 0) break;
        }

        Object[] keys = map.keySet().toArray(); // Object[]
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (Object key : keys) {
            String keyStr = (String) key;
            int count = map.get(keyStr);
            double temp = (double)count * 100.0 / (double)result;
            sb.append(key + " " + String.format("%.4f", temp) + "\n");

        }

        System.out.println(sb.toString());
    }
    
}
