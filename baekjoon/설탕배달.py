N = int(input())

count = 0

while N > 0:
    if N % 5 == 0:
        count += N // 5
        N = N % 5
    else:
        N -= 3
        count += 1
    if N < 0:
        count = -1

print(count)