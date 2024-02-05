def solution(numbers, target):
    answer = 0
    dp=[[] * len(numbers) for _ in range(len(numbers))]
    dp[0] = [numbers[0], -numbers[0]]

    for i in range(1,len(numbers)):
        for j in range(len(dp[i-1])):
            dp[i].append(dp[i-1][j] + numbers[i])
            dp[i].append(dp[i-1][j] - numbers[i])
        
    for i in dp[-1]:
        if i == target:
            answer+=1

    return answer

print(solution([1, 1, 1, 1, 1]	,3))
print(solution([4, 1, 2, 1]	,4))