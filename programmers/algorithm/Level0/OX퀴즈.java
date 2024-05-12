package Level0;

public class OX퀴즈 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] term = new String[3];
        for(int i = 0; i < quiz.length; i++){
            term = quiz[i].split(" ");
            
            if(term[1].equals("+")) {
                if(Integer.parseInt(term[4]) == Integer.parseInt(term[0]) + Integer.parseInt(term[2]))
                   answer[i] = "O";
                else answer[i] = "X";
            }
            if(term[1].equals("-")) {
                if(Integer.parseInt(term[4]) == Integer.parseInt(term[0]) - Integer.parseInt(term[2]))
                   answer[i] = "O";
                else answer[i] = "X";
            }
        }
        return answer;
    }
}
