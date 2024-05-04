import java.util.*;
// 테스트 통과, 틀림
// class Solution {
//     public int[] solution(int[] numbers) {
//         int[] answer = new int[numbers.length+1];
//         Set<Integer> list = new HashSet<>();

//         Arrays.sort(numbers);

//         for (int i = 0; i < numbers.length-1; i++) {
//             for (int j = i+1; j < numbers.length; j++) {
//                 list.add(numbers[i] + numbers[j]);
//             }
//         }
        
//         Integer[] arr = list.toArray(new Integer[list.size()]);
    
//         Arrays.sort(arr);
//         for (int i = 0; i < arr.length; i++) {
//             answer[i] = arr[i];
//         }
        
//         return answer;
//     }
// }

// 테스트 통과, 틀림
// class Solution {
//     public int[] solution(int[] numbers) {
//         int[] answer = new int[numbers.length+1];
//         List<Integer> list = new ArrayList<>();

//         Arrays.sort(numbers);

//         for (int i = 0; i < numbers.length; i++) {
//             for (int j = i+1; j < numbers.length; j++) {
//                 if (!list.contains(numbers[i] + numbers[j])){
//                     list.add(numbers[i] + numbers[j]);
//                 } 
//             }
//         }
        
//         for (int i = 0; i < numbers.length+1; i++) {
//             answer[i] = list.get(i).intValue();
//         }
        
//         return answer;
//     }
// }
    

class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (!list.contains(numbers[i] + numbers[j])){
                    list.add(numbers[i] + numbers[j]);
                } 
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).intValue();
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}