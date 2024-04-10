numbers = []

for _ in range(7):
    numbers.append(int(input()))

cnt = 0
for i in range(7):
    if numbers[i] % 2 != 0:
        cnt +=1 

if cnt == 0:
    print(-1)
else:

    ans = sum(i for i in numbers if i % 2 != 0)
    print(ans)

    minNum = 101
    for num in numbers:
        if num % 2 != 0:
            minNum = min(minNum, num)
    print(minNum)