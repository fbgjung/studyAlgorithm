package Level0;

import java.util.Scanner;

public class 문자열돌리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
        }   
        sc.close();
    }
}
