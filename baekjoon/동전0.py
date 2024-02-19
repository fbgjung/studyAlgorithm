N, K = map(int, input().split(" "))

count = 0
coinValue = []

for _ in range(N):
    coinValue.append(int(input()))

coinValue.sort(reverse=True)

while K > 0:
    for i in range(N):
        if coinValue[i] > K:
            continue
        else:
            count += K // coinValue[i]
            K  = K % coinValue[i]

print(count)