from collections import deque

n, m = map(int, input().split())
graph = []
answer = [[-1] * m for _ in range(n)]

for _ in range(n):
    graph.append(list(map(int, input().split())))

def bfs(x,y):
    q = deque()
    q.append((x,y))
    answer[x][y] = 0

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and answer[nx][ny] == -1:
                answer[nx][ny] = answer[x][y] + 1
                q.append((nx,ny))   

for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            bfs(i,j)

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            answer[i][j] = 0
        print(answer[i][j], end=" ")
    print()