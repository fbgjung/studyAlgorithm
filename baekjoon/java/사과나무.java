package baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * CCW
 */
public class 사과나무 {
    static int result, cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        double area = triangle(x1, y1, x2, y2, x3, y3);
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            double trianglePBC = triangle(x, y, x2, y2, x3, y3);
            double triangleAPC = triangle(x1, y1, x, y, x3, y3);
            double triangleABP = triangle(x1, y1, x2, y2, x, y);

            if (area == (trianglePBC+triangleAPC+triangleABP)) cnt++;
        }
        System.out.println(area);
        System.out.println(cnt);

    }
    static double triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1*(y2-y3)) + (x2*(y3-y1)) + (x3*(y1-y2))) / 2.0;
    }
}