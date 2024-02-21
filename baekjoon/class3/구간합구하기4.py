import sys
input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))

array = [0]
temp = 0

for number in numbers:
    temp += number
    array.append(temp)

for _ in range(M):
    start, end = map(int, input().split())
    print(array[end]-array[start-1])