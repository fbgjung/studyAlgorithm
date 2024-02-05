def solution(m, n, puddles):
    answer = 0
    dp =[[0]*(n+1) for _ in range(m+1)]
    # dp[1][1] = 1
    
    for i in range(1, m+1):
        for j in range(1, n+1):
            if i == 1 and j == 1: continue 
            if [i, j] in puddles:
                dp[i][j] = 0
            else:
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
    
    answer = dp[m][n]

    return answer % 1000000007

print(solution(4,3,[[2,2]]))