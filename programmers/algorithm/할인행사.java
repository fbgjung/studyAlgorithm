import java.util.*;

class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;        
        
        for (int j = 0; j < discount.length-9; j++) { // 0,1,2,3,4
            int[] temp = new int[number.length];
            
            for (int i = j; i < j+10; i++) { // 0-9, 1-10, 2-11, 3-12, 4-13
                for (int k = 0; k < want.length; k++){
                    if(want[k].equals(discount[i])){
                        temp[k] += 1;
                    }
                }
            }
            
            if (Arrays.equals(temp, number)) {
                answer++;
            }
        }
        
        return answer;
    }
}
