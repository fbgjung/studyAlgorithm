n = int(input())
times = list(map(int, input().split()))

Y, M = 0, 0

for time in times:
    Y += (time//30 + 1) * 10
    M += (time//60 + 1) * 15

print(Y, M)  
if Y > M:  print("M", M)
elif M > Y: print("Y", Y)
elif M == Y: print("Y M", Y)
    