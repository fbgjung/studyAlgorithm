N = int(input())

P = list(map(int, input().split(" ")))
P.sort()
sum = 0
temp = [0] * N
temp[0] = P[0]

for i in range(1,N):
    temp[i] = temp[i-1] + P[i]

for i in range(N):
    sum += temp[i]

print(sum)