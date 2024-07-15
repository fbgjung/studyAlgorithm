package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class 잃어버린괄호 {
    static int result;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strArr = str.split("-");

        for (String s : strArr) {
            int temp = 0;
            String[] tempArr = s.split("\\+");
            for (String t : tempArr) {
                temp += Integer.parseInt(t);
            }
            list.add(temp);
        }

        result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }
        System.out.println(result);
    }
}
