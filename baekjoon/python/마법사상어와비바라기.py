# import sys
# input = sys.stdin.readline

# N, M = map(int, input().split())

# graph = [list(map(int, input().split())) for _ in range(N)]
# infos = [list(map(int, input().split())) for _ in range(M)]

# clouds = [[N-1, 0], [N-1, 1], [N-2, 0], [N-2, 1]]

# dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
# dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]

# dx4 = [-1, -1, 1, 1]
# dy4 = [-1, 1, -1, 1]

# for d, s in infos:
#     moved_clouds = []

#     for x, y in clouds:
#         nx = (x + dx[d] * s) % N
#         ny = (y + dy[d] * s) % N
#         graph[nx][ny] += 1 
#         moved_clouds.append([nx, ny])
    
#     for x, y in moved_clouds:
#         count = 0
#         for i in range(4):
#             nx = dx4[i] + x
#             ny = dy4[i] + y
        
#             if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] > 0: count += 1
#         graph[x][y] += count
    
#     new_clouds = []
#     for i in range(N):
#         for j in range(N):
#             if graph[i][j] >= 2 and [i, j] not in moved_clouds: 
#                 graph[i][j] -= 2
#                 new_clouds.append([i,j])
#     clouds = new_clouds

# result = 0
# for i in range(N):
#     for j in range(N):
#         result += graph[i][j]

# print(result)

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
infos = [tuple(map(int, input().split())) for _ in range(M)]


clouds = [[N-1, 0], [N-1, 1], [N-2, 0], [N-2, 1]]
dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]

dx4 = [-1, -1, 1, 1]
dy4 = [-1, 1, -1, 1]

for d, s in infos:
    moved_clouds = []
    visited = [[0]*N for _ in range(N)]

    for x, y in clouds:
        nx = (x + dx[d] * s) % N
        ny = (y + dy[d] * s) % N
        graph[nx][ny] += 1 
        visited[nx][ny] = 1
        moved_clouds.append([nx, ny])
    
    for x, y in moved_clouds:
        count = 0
        for i in range(4):
            nx = dx4[i] + x
            ny = dy4[i] + y
        
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] > 0: count += 1
        graph[x][y] += count
    
    new_clouds = []
    for i in range(N):
        for j in range(N):
            if graph[i][j] >= 2 and not visited[i][j]:
                graph[i][j] -= 2
                new_clouds.append([i,j])
    clouds = new_clouds

result = 0
for i in range(N):
    for j in range(N):
        result += graph[i][j]

print(result)