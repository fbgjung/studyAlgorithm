import java.util.*;
class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes){
            if(!map.containsKey(cloth[1])){
                map.put(cloth[1], 1);
            } else {
                map.put(cloth[1], map.get(cloth[1])+1);
            }
        }
        for (Integer m : map.values()){
            answer *= m + 1;
        }
        return answer-1;
    }
}