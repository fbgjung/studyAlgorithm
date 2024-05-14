package Level0;

public class 문자열계산하기 {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split(" ");
        answer = Integer.parseInt(arr[0]);
        
        for (int i = 1; i < arr.length-1; i++){
            if(arr[i].equals("+")){
                answer += Integer.parseInt(arr[i+1]);
            } else if (arr[i].equals("-")){
                answer -= Integer.parseInt(arr[i+1]);
            }
        }
        return answer;
    }
}
