import java.util.*;
class 배열의원소만큼추가하기 {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        
        for (int a : arr){
            for (int j = 0; j < a; j++){
                result.add(a);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}