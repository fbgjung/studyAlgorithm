from collections import deque

m, n, k = map(int, input().split())

recs = []
board = [[0] * n for _ in range(m)]

for _ in range(k):
    recs.append(list(map(int, input().split())))

# 직사각형 칠하기
for rec in recs:
    for i in range(m - rec[3], rec[3] - rec[1] + (m - rec[3])):
        for j in range(rec[0], rec[0] + (rec[2] - rec[0])):
            board[i][j] = 1

def bfs(x,y):
    cnt = 1
    q = deque()
    q.append((x,y))
    board[x][y] = 1

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == 0:
                cnt += 1
                board[nx][ny] = 1
                q.append((nx,ny))

    return cnt

# 넓이 구하기
result = []
for i in range(m):
    for j in range(n):
        if board[i][j] == 0:
            result.append(bfs(i,j))
print(len(result))
print(*sorted(result))