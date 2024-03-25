import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

n,m = map(int, input().split())

lab = [list(map(int, input().split())) for _ in range(n)]

walls = []
safe_zone = []

def bfs():
    safe = 0
    while q:
        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        x, y = q.popleft()

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < n and 0 <= ny < m and temp_lab[nx][ny]  == 0:
                temp_lab[nx][ny] = 2
                q.append((nx, ny))

    for i in range(n):
        for j in range(m):
            if temp_lab[i][j] == 0:
                safe += 1
    return safe
    

for i in range(n):
    for j in range(m):
        if lab[i][j] == 0:
            walls.append([i,j])

result = 0            
for wall in combinations(walls, 3):
    temp_lab = [row[:] for row in lab]

    for wx,wy in wall:
        temp_lab[wx][wy] = 1 
    
    q = deque()
    for x in range(n):
        for y in range(m):
            if temp_lab[x][y] == 2: 
                q.append((x,y))
    result = max(result,bfs())
    
print(result)