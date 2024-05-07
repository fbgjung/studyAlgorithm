package Level0;

public class 이어붙인수 {
    public int solution(int[] num_list) {
        String even = "";
        String odd = "";
        
        for (int i = 0; i < num_list.length; i++){
            if (num_list[i] % 2 == 0){
                even += Integer.toString(num_list[i]);
            } else {
                odd += Integer.toString(num_list[i]);
            }
        }
        
        return Integer.parseInt(even) +Integer.parseInt(odd);
    }
}

/**
 * other solution
 */
class 이어붙인수2 {
    public int solution(int[] num_list) {
        int answer = 0;
        int even = 0;
        int odd = 0;
        
        for (int num : num_list){
            if(num % 2 == 0){
                even *= 10;
                even += num;
            } else {
                odd *= 10;
                odd += num;
            }
        }
        answer = even + odd;
        return answer;
    }
}