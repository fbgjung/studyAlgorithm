import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int, input().split()))
result = []

set_array = sorted(list(set(array)))

for i in array:
    result.append(set_array.index(i))

for i in range(N):
    print(result[i], end=' ')