from collections import deque
M, N = map(int, input().split())

graph = [[] for _ in range(N)]

for i in range(N):
    graph[i] = list(map(int, input().split(" ")))

q = deque()
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            q.append((i,j))

def bfs():
    while q:
        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        x,y = q.popleft()
        
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0:
                q.append((nx,ny))
                graph[nx][ny] = graph[x][y] + 1

bfs()
result = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            print(-1)
            exit()
        result = max(result, graph[i][j] - 1)
print(result)
