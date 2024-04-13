n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]

chicken_location = []
for i in range(n):
    for j in range(n):
        if city[i][j] == 2:
            chicken_location.append([i,j])
def calculate_min_distance(choice,city):
    global ans
    total_distance = 0
    for i in range(n):
        for j in range(n):
            if city[i][j] == 1:
                min_location = 1e9
                for x, y in choice:
                    min_location = min(min_location, abs(i-x) + abs(j-y))
                total_distance += min_location
    return total_distance

res = 1e9
choice = []
def dfs(start, depth,city):
    global choice
    global res
    if depth == m:
        res = min(res, calculate_min_distance(choice, city))
        return

    for c in range(start, len(chicken_location)):
        if chicken_location[c] is not choice:
            choice.append(chicken_location[c])
            dfs(c+1, depth+1, city)
            choice.pop()

dfs(0,0,city)
print(res)