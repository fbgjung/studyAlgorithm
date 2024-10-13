package baekjoon.java;

import java.util.*;
import java.io.*;

public class 단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        boolean tag = false;

        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);

            if (c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                tag = true;
                sb.append(c);
            } else if(c == '>') {
                tag = false;
                sb.append(c);
            } else if(tag) {
                sb.append(c);
            } else if(c == ' '){
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.add(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}
