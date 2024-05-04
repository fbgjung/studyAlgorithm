import java.util.*;

/**
 * 레전드 시간초과
 */
class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        int idx = 0;
        
        while(idx < topping.length-2){
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();
            
            for (int i = 0; i<=idx; i++){
                if(!first.contains(topping[i])){
                    first.add(topping[i]);
                }
            }
            
            for (int i = idx+1; i < topping.length; i++){
                if(!second.contains(topping[i])){
                    second.add(topping[i]);
                }
            }
            
            idx++;
            
            if(first.size() == second.size()) {
                answer++;
            }
        }
        return answer;
    }
}