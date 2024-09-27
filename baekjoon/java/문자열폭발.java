package baekjoon.java;

import java.io.*;

public class 문자열폭발 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        int str_len = str.length();
        int bomb_len = bomb.length();

        for (int i = 0; i < str_len; i++) {
            sb.append(str.charAt(i));

            // 폭발 문자열과 비교할 길이가 되면
            if(sb.length() >= bomb_len) {
                boolean isMatch = true;
                for (int j = 0; j < bomb_len; j++) {
                    if (sb.charAt(sb.length() - bomb_len + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    sb.delete(sb.length() - bomb_len, sb.length());
                }
            }
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
