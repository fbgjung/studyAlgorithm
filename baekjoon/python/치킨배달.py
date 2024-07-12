import sys
from itertools import combinations

input = sys.stdin.readline

n,m = map(int, input().split())

city_map = list(list(map(int, input().split())) for _ in range(n))

result = 9999999

chicken = [] 
house = [] 

for i in range(n):
    for j in range(n):
        if city_map[i][j] == 1:
            house.append([i,j])
        elif city_map[i][j] == 2:
            chicken.append([i,j])

for chick in combinations(chicken,m):
    temp = 0
    for h in house:
        house_chicken_len = 999
        for j in range(m):
            house_chicken_len = min(house_chicken_len, abs(h[0]-chick[j][0]) + abs(h[1]-chick[j][1]))
        temp += house_chicken_len
    result = min(result, temp)

print(result)