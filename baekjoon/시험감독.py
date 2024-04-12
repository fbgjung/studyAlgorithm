n = int(input())
datas = list(map(int, input().split()))
b, c = map(int, input().split())
res = n
for i in range(n):
    datas[i] -= b

for i in range(n):
    if datas[i] > 0:
        if datas[i] % c:
            res += (datas[i] // c) + 1
        else:
            res += (datas[i] // c)
print(res)