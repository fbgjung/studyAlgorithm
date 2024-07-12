n, m = map(int, input().split())
x, y, direction = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]
visited =[[0] * m for _ in range(n)]

# 북동남서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

clean_cnt = 1 
visited[x][y] = 1 

while True:
    flag = 0 # 주변에 청소해야할 칸이 있는지 현재는 없음요
    
    for _ in range(4):
        direction = (direction + 3) % 4
        nx = x + dx[direction]
        ny = y + dy[direction]
        
        if 0 <= nx < n and 0 <= ny < m and room[nx][ny] == 0:
            if visited[nx][ny] == 0:
                visited[nx][ny] = 1
                clean_cnt += 1
                x, y = nx, ny
                flag = 1 # 청소함
                break
            
    if flag == 0:
        # 후진
        if room[x-dx[direction]][y-dy[direction]] == 1:
            print(clean_cnt)
            break
        else:
            x, y = x-dx[direction], y-dy[direction]