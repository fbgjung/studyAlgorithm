N = int(input())

hi = []

for _ in range(N):
    x,y = map(int, input().split())
    hi.append([y,x])

hi = sorted(hi)

for i in hi:
    print(i[1], i[0])
