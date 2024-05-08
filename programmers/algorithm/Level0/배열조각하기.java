package Level0;

import java.util.*;
/**
 * 테케 통과, 실행 다 틀림
 */
// public class 배열조각하기 {
//     public int[] solution(int[] arr, int[] query) {
//         List<Integer> list = new ArrayList<>();
//         int idx = 0;
//         int arrIdx = 0;
        
//         for(int i = 0; i < arr.length; i++){
//             list.add(arr[i]);
//         }
        
//         for (int i  = 0; i < query.length; i++){
//             idx = query[i]; //4 1 2 
            
//             if(arr[arrIdx] % 2 == 0) {
//                 arrIdx++;
//                 for (int k = idx+1; k < list.size(); k++){
//                     list.remove(arr[k]);
//                 }
//             } else {
//                 arrIdx++;
//                 for (int j = 0; j < idx; j++){
//                     list.remove(j);
//                 }
//             }
//         }
        
//         int[] answer = new int[list.size()];
//         for (int i = 0; i < list.size(); i++){
//             answer[i] = list.get(i);
//         }
        
//         return answer;
//     }   
// }

/**
 * Deque 활용하기
 */
class 배열조각하기 {
    public ArrayDeque<Integer> solution(int[] arr, int[] query) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        
        for (int a : arr) {
            list.add(a);
        }
        
        for (int i = 0; i < query.length; i++) {
            int len = list.size(); // 중요!!
            if(i % 2 == 0){
                for (int j = query[i] + 1; j < len; j++) {
                    list.removeLast();
                }
            }
            else {
                for (int j = 0;  j < query[i]; j++) {
                    list.remove();
                }
            }
        }
        return list;
    }
}