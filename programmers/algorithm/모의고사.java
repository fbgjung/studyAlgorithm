import java.util.*;
class 모의고사 {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] scores = new int[3];
        
        Integer[] firstInit = {1,2,3,4,5};
        Integer[] secondInit = {2, 1, 2, 3, 2, 4, 2, 5};
        Integer[] thirdInit = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();

        for(int i = 0; i < 2000; i++){
            first.addAll(Arrays.asList(firstInit));
        }

        for(int i = 0; i < 1250; i++){
            second.addAll(Arrays.asList(secondInit));
        }
        
        for(int i = 0; i < 1000; i++){
            third.addAll(Arrays.asList(thirdInit));
        }
        
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == first.get(i)){ scores[0] ++; }
            if (answers[i] == second.get(i)){ scores[1] ++; }
            if (answers[i] == third.get(i)){ scores[2] ++; }
        }        

        int maxScore = 0;
        for (int s : scores) {
            maxScore = Math.max(maxScore, s);
        }
            
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) { 
                list.add(i+1); 
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
    
        return answer;
    }
}