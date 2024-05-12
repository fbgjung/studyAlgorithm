package Level0;

public class 코드처리하기 {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        char[] arr = code.toCharArray();
        
        for (int i = 0; i < arr.length; i++){
            if (mode == 0){
                if(arr[i] != '1' && i % 2 == 0) {
                    answer += arr[i];
                } else if ( arr[i] == '1') { mode = 1; }
            }  
            
            else {
                if(arr[i] != '1' && i % 2 != 0) {
                    answer += arr[i];
                } else if (arr[i] == '1') { mode = 0; }
            }
        }
        
        if (answer.length() == 0) {
            answer = "EMPTY";
        }
    
        return answer;
    }   
}