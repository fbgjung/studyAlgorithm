from collections import deque

test = int(input())

def bfs():
    dx = [-2,-1,1,2,2,1,-1,-2]
    dy = [-1,-2,-2,-1,1,2,2,1]

    q = deque()
    q.append((start[0], start[1]))

    while q:
        x,y = q.popleft()

        if x == end[0] and y == end[1]:
            return graph[x][y] -1
        
        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == 0:
                q.append((nx,ny))
                graph[nx][ny] = graph[x][y] + 1

while test > 0:
    N = int(input())
    start = list(map(int, input().split()))
    end = list(map(int, input().split()))
    graph = [[0] *N for _ in range(N)]
    graph[start[0]][start[1]] = 1
    print(bfs())
    test -= 1