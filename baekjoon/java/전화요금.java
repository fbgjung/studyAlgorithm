package baekjoon.java;
import java.util.*;
public class 전화요금 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int result = 0;
        
        while (t > 0){
            t--;
            String[] start = sc.next().split(":");
            int start_h = Integer.parseInt(start[0]);
            int start_m = Integer.parseInt(start[1]);
            int dd = sc.nextInt();

            int end_h = start_h;
            int end_m = 0;

            if (start_m + dd >= 60) {
                end_m = start_m + dd - 60;
                end_h = start_h + 1;
                if (end_h > 23) {
                    end_h = 0;
                }
            } else {
                end_m = start_m + dd;
            }

            if (7 <= start_h && start_h <= 18) {
                if (end_h == 19) {
                    result += (60-start_m) * 10 + end_m * 5;
                } else {
                    result += dd * 10;
                }
            }

            if ((0 <= start_h && start_h <= 6) || (19 <= start_h && start_h <= 23)){
                if (end_h == 7) {
                    result += (60-start_m) * 5 + end_m * 10;
                } else {
                    result += dd * 5;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }
}