T = int(input())

coins = [25,10,5,1]

for _ in range(T):
    answer = []
    C = int(input())
    for coin in coins:
        if C >= coin:
            temp = C // coin
            C = C % coin
            answer.append(temp)
        else: answer.append(0)

    for a in answer:
        print(a, end=' ')
    print()