N, M = map(int, input().split())

result = []

a = set()
for _ in range(N):
    a.add(input())

b = set()
for _ in range(M):
    b.add(input())

for listen in a:
    if listen in b:
        result.append(listen)

print(len(result))
result = sorted(result)
for i in result:
    print(i)