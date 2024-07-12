T = int(input())

times = [300, 60, 10]
answer = []

for time in times:
    if T >= time:
        temp = T // time
        T = T % time
        answer.append(temp)
    else: answer.append(0)

if T > 0: print(-1)
else: 
    for a in answer:
        print(a, end=" ")