t = int(input())

for _ in range(t):
    ans = []
    quiz = input()
    total = 0
    for i in range(len(quiz)):

        if quiz[i] =='O':
            total += 1
            ans.append(total)
        else: 
            total = 0
            ans.append(total)
    print(sum(ans))