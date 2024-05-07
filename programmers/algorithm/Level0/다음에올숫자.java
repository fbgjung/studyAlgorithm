package Level0;

public class 다음에올숫자 {
    /**
     * else if로 해주기 !!!
     */
    public int solution(int[] common) {
        int answer = 0;

        // 등차수열인가
        if (common[1] - common[0] == common[2] - common[1]){
            int diff = common[1] - common[0];
            answer = common[common.length-1] + diff;
        }
        
        // 등비수열인가
        else if (common[1] / common[0] == common[2] / common[1]){
            int diff = common[1] / common[0];
            answer = common[common.length-1] * diff;
        }
        
        return answer;
    }
    
}
