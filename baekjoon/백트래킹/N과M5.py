n, m = map(int, input().split())
data = list(map(int, input().split()))

data.sort()

s = []
def dfs():
    if len(s) == m:
        print(' '.join(map(str, s)))
        return

    for i in range(n):
        if data[i] not in s:
            s.append(data[i])
            dfs()
            s.pop()
dfs()