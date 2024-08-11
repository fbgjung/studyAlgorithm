# 최장 증가 부분 수열 (LIS)
LIS (Longest Increasing Subsequence) 알고리즘은 수열에서 연속적으로 값이 증가하는 요소들을 연결시켰을 때, 그 길이가 가장 길어지는 수열의 길이를 찾는 방법이다.

예를 들어, 수열 A = {10,20,10,30,20,50} 인 경우에  
가장 긴 증가하는 부분 수열은 A = {**10**,**20**,10,**30**,20,**50**} 이고 길이는 4이다.

## LIS를 구하는 전략  
1. Dynamic Programming
2. Segment Tree
3. Binary Search

## 1. Dynamic Programming - O(n^2)
일반적으로 간편한 방법은 DP를 이용하는 것이다.
```java
// 크기가 6인 수열이 있다고 할 때
int[6] arr = {10,20,10,30,20,50};
int[6] dp = {1, 1, 1, 1, 1, 1};

for (int i = 1; i < n; i++) {
    for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
            dp[i] = Math.max(dp[i], dp[j]+1);
        }
    }
}
```
dp[i]는 i 번째 인덱스에서 끝나는 최장 증가 부분 수열의 길이를 의미한다.  
1. arr 배열 인덱스를 한 칸씩 늘려가면서  
2. arr 배열 인덱스보다 작은 인덱스들을 하나씩 살펴보면서 dp 배열을 갱신한다.


### [DP로 풀 수 있는 LIS 문제]
<hr>

1. [[백준][실버2][DP] 가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)  
[🐰 내 풀이](https://github.com/fbgjung/studyAlgorithm/blob/main/baekjoon/java/%EA%B0%80%EC%9E%A5%EA%B8%B4%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94%EB%B6%80%EB%B6%84%EC%88%98%EC%97%B4.java)

2. [[백준][골드5][DP] 전깃줄](https://www.acmicpc.net/problem/2565)  
[🐰 내 풀이](https://github.com/fbgjung/studyAlgorithm/blob/main/baekjoon/java/%EC%A0%84%EA%B9%83%EC%A4%84.java)
- **정렬시 람다식으로 할 수 있지만 람다식의 경우 바이트 코드로 변환하는 것이 아닌 언어 런타임에게 위임하기 때문에 시간과 메모리를 더 잡아먹는다고 한다**

그런데 위 알고리즘은 인풋 값이 백만 개 정도만 되어도 O(n^2)의 알고리즘은 실행시간이 10초 이상 소요된다.


## 2. Binary Tree - O(log n)
**시간복잡도를 개선**하기 위하여 LIS에 `이분탐색`을 활용한다.  
LIS의 형태를 유지하기 위해 주어진 배열의 인덱스를 하나씩 살펴보면서 그 숫자가 들어갈 위치를 이분탐색으로 탐색해서 넣는다.  

현재 가장 긴 부분 수열을 추적하면서 새로운 수가 들어왔을 때 이분 탐색을 통해 **적절한 위치에 삽입하거나 교체하는 방법**이다.


<img width="490" alt="스크린샷 2024-08-11 오후 8 06 14" src="https://github.com/user-attachments/assets/6fbe94c8-185d-4e9a-915f-507c8b95d9c2">

### [최장 증가 부분 수열을 보장하는 이유]
lis 배열이 각 길이의 증가 부분 수열의 최소값을 유지하도록 설계되어 있기 때문이다.
작은 값을 유지하는 것은 이후에 더 긴 증가 부분 수열이 나타날 가능성을 남기기 때문에, 최장 수열이 정확히 계산된다.

새로운 원소가 들어올 때
- 만약 새로운 원소가 lis 배열의 마지막 값보다 크다면, lis 배열에 추가한다. 
- 그렇지 않다면, lis 배열에서 이분 탐색을 통해 이 원소가 들어갈 위치를 찾아 해당 위치의 값을 대체한다. 수열의 길이는 변하지 않지만, **더 작은 값으로 대체함으로써 더 긴 수열로 확장될 가능성을 남기는 것**이다.

### [이분탐색으로 풀 수 있는 LIS 문제]
1. [[백준][골드2][DP] 반도체 설계](https://www.acmicpc.net/problem/2352)  
[🐰 내 풀이](https://github.com/fbgjung/studyAlgorithm/blob/main/baekjoon/java/%EB%B0%98%EB%8F%84%EC%B2%B4%EC%84%A4%EA%B3%84_2.java)
- 입력 크기가 최대 40,000이기 때문에 O(N^2)의 시간복잡도를 가지는 DP 방식은 시간 초과를 발생시킬 수 있다. 

## 참고
[알고리즘 - 최장 증가 부분 수열(LIS) 알고리즘](https://chanhuiseok.github.io/posts/algo-49/)