class 수박수박수박수박수박수 {
    public String solution(int n) {
        String answer = "";
        String watermelon = "수박";
        String water = "수";
        
        if (n % 2 == 0){
            for (int i = 0; i < n/2; i++){
                answer += watermelon;
            }
        } else {
            for (int i = 0; i < n/2; i++){
                answer += watermelon;
            }
            answer += water;
            
        }
        return answer;
    }
}