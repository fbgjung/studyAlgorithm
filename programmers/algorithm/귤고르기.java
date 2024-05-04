import java.util.*;

class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        int maxT = tangerine[tangerine.length-1];

        Integer[] sizes = new Integer[maxT+1];
        Arrays.fill(sizes, 0);
        
        for (int t : tangerine) {
            sizes[t] += 1;
        }

        Arrays.sort(sizes, Collections.reverseOrder());

        for (int i = 0; i < sizes.length; i++){
            if (sizes[i] <= k) {
                answer ++;
                k -= sizes[i];
                
                if (k <= 0){
                    break;
                }
            } else {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}