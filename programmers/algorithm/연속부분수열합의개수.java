import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        
        // 기존 배열 두배로 만들기
        for (int i = 0; i < 2; i++){
            for (int e : elements){
                list.add(e);
            }
        }
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j <= elements.length; j++){
                List<Integer> temp = list.subList(i,i+j);
                int sum = 0;
                for (int t : temp){
                    sum += t;
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
