from collections import deque

def bfs(x,y,target):
    q = deque()
    q.append((x,y))    
    count = 0

    while q:
        x,y = q.popleft()
        graph[x][y] = "X"
        count+=1

        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < M and 0 <= ny < N and graph[nx][ny] == target:
                q.append((nx, ny))
                graph[nx][ny] = "X"
                
    return count **2
            
N, M = map(int, input().split())
graph=[]

for _ in range(M):
    graph.append(list(input()))

white = 0
blue = 0
for i in range(M):
    for j in range(N):
        if graph[i][j] == "W":
            white += bfs(i,j,"W")
        elif graph[i][j] == "B":
            blue += bfs(i,j,"B")
        
print(white,blue)