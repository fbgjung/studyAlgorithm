from collections import deque

def bfs(x,y):
    queue = deque()
    queue.append((x,y))

    dx = [-1,1,0,0,-1,-1,1,1]
    dy = [0,0,-1,1,1,-1,1,-1]

    while queue: 
        x, y = queue.popleft()
        graph[x][y] = 0

        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))


while True:
    w, h  = map(int, input().split())
    graph = [[] for _ in range(h)]

    if w == 0 and h == 0:
        break

    for i in range(h):
        graph[i] = (list(map(int, input().split())))

    count = 0
    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                count+=1
                bfs(i,j)

    print(count)