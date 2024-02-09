paper = [[0 for _ in range(100)] for _ in range(100)]

N = int(input())
count = 0

for _ in range(N):
    x,y = list(map(int, input().split()))

    for x_idx in range(x, x+10):
        for y_idx in range(y, y+10):
            paper[x_idx][y_idx] = 1
    
for i in paper:
    count += i.count(1)
print(count)

