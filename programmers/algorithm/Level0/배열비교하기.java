package Level0;

class 배열비교하기 {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int arr1Sum = 0;
        int arr2Sum = 0;
        
        
        if(arr1.length != arr2.length){
            answer = arr1.length > arr2.length ? 1 : -1;
        } else {
            for (int i = 0; i < arr1.length; i++){
                arr1Sum += arr1[i];
                arr2Sum += arr2[i];
            }
            
            if(arr1Sum > arr2Sum) answer = 1;
            else if(arr1Sum < arr2Sum) answer = -1;
            else answer = 0;
        }
        return answer;
    }
}
