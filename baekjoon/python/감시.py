import copy
from collections import deque
n,m = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]
ans = 1e9
modes=[
    [],
    [[0],[1],[2],[3]],
    [[0,1], [2,3]],
    [[0,2], [0,3], [1,2], [1,3]],
    [[0,2,3], [0,1,3], [2,0,1], [2,3,1]],
    [[0,1,2,3]]
]

dx = [-1,1,0,0]
dy = [0,0,-1,1]

cctvs = []
for i in range(n):
    for j in range(m):
        if room[i][j] in [1,2,3,4,5]:
            cctvs.append([i,j, room[i][j]])
            
# 주어진 방향으로 CCTV가 감시하는 영역을 채운다.
def fill(rooms, mode, x, y):
    for direction in mode:
        nx, ny = x, y
        
        while True:
            nx += dx[direction]
            ny += dy[direction]
            if not (0 <= nx < n and 0 <= ny < m):
                break
            if rooms[nx][ny] == 6:
                break
            elif rooms[nx][ny] == 0:
                rooms[nx][ny] = -1 
                
# 재귀적으로 모든 CCTV의 조합을 탐색하며, 각 단계에서 사각지대의 최소 크기를 계산한다.
def dfs(depth, rooms):
    global ans
    if depth == len(cctvs):
        cnt = 0
        for i in range(n):
            cnt += rooms[i].count(0)
        ans = min(ans, cnt)
        return
            
    temp = copy.deepcopy(rooms)
    x, y, cctv_num = cctvs[depth] # 1, 2, 2
    for mode in modes[cctv_num]: # [0],[1],[2],[3]
        fill(temp, mode, x, y)    
        dfs(depth + 1, temp) # 그 다음 CCTV 선택하여 모든 조합 탐색
        temp = copy.deepcopy(rooms)
        
dfs(0,room)
print(ans)