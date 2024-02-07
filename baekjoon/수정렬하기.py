N = int(input())

array = []

for _ in range(N):
    x = int(input())
    array.append(x)

array.sort()
print('\n'.join(map(str, array)))