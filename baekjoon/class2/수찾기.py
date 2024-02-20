import sys

N = int(input())
A = list(map(int, sys.stdin.readline().split()))

M = int(input())
targets = list(map(int, sys.stdin.readline().split()))

for target in targets:
    if target in A:
        print(1)
    else:
        print(0)