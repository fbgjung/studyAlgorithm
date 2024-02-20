N = int(input())

array = []

for _ in range(N):
    x,y = list(map(int, input().split()))
    array.append([x,y])

array.sort()

for i in array:
    print(i[0],i[1])