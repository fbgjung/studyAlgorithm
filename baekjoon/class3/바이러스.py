N = int(input())
line = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(line):
    u,v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (N+1)

def dfs(v):
    global count
    count += 1

    visited[v] = True

    for i in graph[v]:
        if visited[i] == False:
            visited[i] = True
            dfs(i)

    return count

count = 0
print(dfs(1)-1)