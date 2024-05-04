class 문자열내p와y의개수 {
    boolean solution(String sen) {
        boolean answer = true;

        sen = sen.toUpperCase();
        int p = 0;
        int y = 0;
        String[] arr = sen.split("");
        
        for (String s : arr){
            if (s.equals("P")) {
                p ++;
            }
            if(s.equals("Y")) {
                y++;
            }
        }
        
        if (p == y) {
            answer = true;
        } else { answer = false; }

        return answer;
    }
}