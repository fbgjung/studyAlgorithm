package Level0;

import java.util.*;

public class 문자열정렬하기2 {

    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] c = my_string.toCharArray();
        
        Arrays.sort(c);
        return String.valueOf(c); // 문자 배열을 문자열로
    }
}
