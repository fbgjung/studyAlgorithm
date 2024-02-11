N = int(input())

road = []
dp = [[0] * 3 for _ in range(N)]

for _ in range(N):
    rgb = list(map(int, input().split()))
    road.append(rgb)

dp[0] = road[0]

for i in range(1, N):
    for j in range(3):
        if j == 0:
            dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + road[i][j] 
        elif j == 1:
            dp[i][j] = min(dp[i-1][0], dp[i-1][2]) + road[i][j]
        elif j == 2:
            dp[i][j] = min(dp[i-1][0], dp[i-1][1]) + road[i][j]

answer = min(dp[N-1])
print(answer)