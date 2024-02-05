def solution(triangle):
    dp = [[] * len(triangle) for _ in range(len(triangle))]
    dp[0] = triangle[0]

    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j == 0:
                dp[i].append(dp[i-1][0] + triangle[i][0])
            elif j == i:
                dp[i].append(dp[i-1][j-1] + triangle[i][j])
            else:
                dp[i].append(max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j])

    answer = max(dp[len(triangle)-1])
    return answer

print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))