S = list(input())

targets = 'abcdefghijklmnopqrstuvwxyz'

for target in targets:
    if target in S:
        print(S.index(target), end=' ')
    else:
        print(-1, end=' ')