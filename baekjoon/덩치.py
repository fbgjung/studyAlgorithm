N = int(input())
data = []

for _ in range(N):
    x, y = map(int, input().split())
    data.append([x, y])

score = [1] * N

for i in range(N):
    for j in range(N):
        if i != j and data[i][0] < data[j][0] and data[i][1] < data[j][1]:
            score[i] += 1

print(' '.join(map(str, score)))