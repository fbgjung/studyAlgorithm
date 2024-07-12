N, M, X, Y, K = map(int, input().split())
game_map = []

for i in range(N):
    row = list(map(int, input().split()))
    game_map.append(row)

move = list(map(int, input().split()))

dice = [0,0,0,0,0,0]
dx = [0,0,0,-1,1]
dy = [0,1,-1,0,0]

for m in move:
    nx = X + dx[m]
    ny = Y + dy[m]

    if not (0 <= nx < N and 0 <= ny < M):
        continue

    north, back, east, west, front ,south = dice[0],dice[1],dice[2],dice[3],dice[4],dice[5]
    if m == 1: dice[3],dice[0],dice[5],dice[2] = north, east, west, south 
    elif m == 2: dice[2],dice[5],dice[0],dice[3] = north, east, west, south
    elif m == 3: dice[4],dice[0],dice[5],dice[1] = north, back, front ,south
    elif m == 4: dice[1],dice[5],dice[0],dice[4] = north, back, front ,south

    if game_map[nx][ny] != 0:
        dice[5] = game_map[nx][ny]
        game_map[nx][ny] = 0

    else:
        game_map[nx][ny] = dice[5]


    print(dice[0])
    X, Y = nx, ny