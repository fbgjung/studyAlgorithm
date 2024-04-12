n, m = map(int, input().split())
data = list(map(int, input().split()))

data.sort()

s = []
def dfs(start):
    if len(s) == m:
        print(' '.join(map(str, s)))
        return

    for i in range(start, n):
        if data[i] not in s:
            s.append(data[i])
            dfs(i)
            s.pop()
            
dfs(0)