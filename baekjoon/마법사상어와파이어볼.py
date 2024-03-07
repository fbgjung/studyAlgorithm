N, M, K = map(int, input().split()) 
fireballs = []

for _ in range(M):
    r,c,m,s,d = list(map(int, input().split()))
    fireballs.append([r-1,c-1,m,s,d]) 

graph = [[[] for _ in range(N)] for _ in range(N)]

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

for _ in range(K):
    while fireballs:
        r,c,m,s,d = fireballs.pop(0)
        nx = (r + dx[d] * s) % N
        ny = (c + dy[d] * s) % N
        graph[nx][ny].append([m,s,d])
 
    for i in range(N):
        for j in range(N):
            if len(graph[i][j]) >= 2:
                total_m, total_s, count_odd, count_even, count = 0,0,0,0,len(graph[i][j])
                while graph[i][j]:
                    m,s,d = graph[i][j].pop(0)
                    total_m += m
                    total_s += s
                    if d % 2: count_odd += 1
                    else: count_even += 1

                if count_odd == count or count_even == count:
                    new_d = [0,2,4,6]
                else:
                    new_d = [1,3,5,7]
                if total_m//5: 
                    for d in new_d:
                        fireballs.append([i,j, total_m//5, total_s//count, d])

            elif len(graph[i][j]) == 1:
                fireballs.append([i,j] + graph[i][j].pop())

print(sum([fireball[2] for fireball in fireballs]))