A, B = map(int, input().split())

count = 1

while B > A:
    count += 1

    if B % 10 == 1:
        B  = B // 10
    elif B % 2  == 0:
        B = B // 2
    else:
        break

if B == A:
    print(count)
else:
    print(-1)
