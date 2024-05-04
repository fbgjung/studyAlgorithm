import java.util.*;

class 예산 {
    public int solution(int[] d, int budget) {
        int count = 0;
        
        // 정렬하기
        Integer[] new_d = Arrays.stream(d).boxed().toArray(Integer[]::new);
        Arrays.sort(new_d);
        
        for (Integer i : new_d){
                    
            if (i > budget) {
                break;
            } else {
                budget -= i;
                count ++;
            }
        }
        return count;
    }
}                