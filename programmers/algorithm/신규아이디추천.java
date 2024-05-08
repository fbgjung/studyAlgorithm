public class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        answer = answer.equals("") ? "a" : answer;
        answer = answer.length() >= 16 ? answer.substring(0,15) : answer;
        answer = answer.replaceAll("[.]$", "");
        
        char last = answer.charAt(answer.length()-1);
        if (answer.length() <= 2){
            while (answer.length() < 3 ){
                answer+= last;
            }
        }
        
        return answer;
        
    }
}