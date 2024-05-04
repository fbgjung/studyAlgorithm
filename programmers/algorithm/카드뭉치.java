/**
 * 틀림
 * 반레 존재
 */
// class Solution {
//     public String solution(String[] cards1, String[] cards2, String[] goal) {
//         String answer = "Yes";
//         List<String> temp1 = new ArrayList<>();
//         List<String> temp2 = new ArrayList<>();

//         for (int i = 0; i < goal.length; i++) {
//             for(String card : cards1) {
//                 if (goal[i].equals(card)){
//                     temp1.add(goal[i]);
//                 }
//             }
            
//             for(String card2 : cards2) {
//                 if (goal[i].equals(card2)){
//                     temp2.add(goal[i]);
//                 }
//             }
//         }
        
//         for (int i = 0; i < cards1.length; i++) {
//             if (!cards1[i].equals(temp1.get(i))){
//                 answer = "No";
//                 break;
//             } 
//         }
        
//         for (int i = 0; i < cards2.length; i++) {
//             if (!cards2[i].equals(temp2.get(i))){
//                 answer = "No";
//                 break;
//             } 
//         }
        
//         return answer;
//     }
// }

/**
 * success
 */
class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx1 = 0;
        int idx2 = 0;
        
        for (String g : goal) {
            if (idx1 < cards1.length && g.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < cards2.length && g.equals(cards2[idx2])) {
                idx2++;
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}
