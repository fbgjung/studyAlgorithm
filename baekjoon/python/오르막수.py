# import sys
# sys.setrecursionlimit(10**6)

# N = int(input())

# s = []
# answer = 0

# def dfs(start):
#     global answer
#     if len(s) == N:
#         answer += 1
#         return
    
#     for i in range(start, 10):
#         s.append(i)
#         dfs(i)
#         s.pop()
    
#     return answer

# print(dfs(0) % 10007)

N = int(input())
dp = [1] * 10

for i in range(1,N):
    for j in range(1,10):
        dp[j] += dp[j-1]

print(sum(dp)%10007)