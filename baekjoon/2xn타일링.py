n = int(input())
dp=[0] * (n+1)
print("초기",dp)
dp[0] = 1
dp[1] = 2

for i in range(2,n):
    dp[i] = (dp[i-1] + dp[i-2]) % 10007
print(dp)
print(dp[n-1])