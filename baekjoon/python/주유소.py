N = int(input()) 
roads = list(map(int, input().split())) 
costs = list(map(int, input().split())) 

min_cost = costs[0]
answer = 0

for i in range(N-1):
    if costs[i] < min_cost:
        min_cost = costs[i]
        print(min_cost)
    
    answer += roads[i] * min_cost

print(answer)