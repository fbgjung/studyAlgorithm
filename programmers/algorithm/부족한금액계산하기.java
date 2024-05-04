class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalPrice = 0;
        
        for (int i = 1; i <= count; i++){
            totalPrice += price * i;
        }

        answer = totalPrice - money;
        
        // 금액이 부족하지 않을 경우
        if (answer <= 0){
            answer = 0;
        }
        
        return answer;
    }
}