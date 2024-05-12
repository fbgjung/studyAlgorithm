public class 삼총사 {
    public int solution(int[] number) {
        int answer = 0;
        int idx = 0;
        
        while (true) {
            for (int i = idx+1; i < number.length - 1; i++){
                for (int j = i+1; j < number.length; j++) {
                    if (number[idx] + number[i] + number[j] == 0) {
                        answer++;
                    }
                }
            }
            idx ++;
            
            if(idx == number.length-2) break;
        }
        return answer;
    }
}
