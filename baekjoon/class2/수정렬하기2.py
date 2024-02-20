import sys

N = int(input())
array = []

for _ in range(N):
    array.append(int(sys.stdin.readline()))

array.sort()

for i in array:
    print(i)
