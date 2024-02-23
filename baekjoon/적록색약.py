from collections import deque 

N = int(input())
graph = [[] for _ in range(N)]

for i in range(N):
    graph[i] = list(map(str,input()))

def bfs(x,y):
    q = deque()
    q.append((x,y))
    current_color = graph[x][y]
    visited[x][y] = 1
    
    while q:
        x,y = q.popleft()

        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == current_color and not visited[nx][ny]:
                q.append((nx,ny))
                visited[nx][ny] = 1
                
cnt1 = 0
visited = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt1 += 1
            bfs(i,j)        

for i in range(N):
    for j in range(N):
        if graph[i][j] == "R":
            graph[i][j] = "G"

cnt2 = 0
visited = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
         if not visited[i][j]:
            cnt2 += 1
            bfs(i,j)
            
print(cnt1, cnt2)