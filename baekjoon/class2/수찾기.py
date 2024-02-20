import sys

N = int(input())
A = list(map(int, sys.stdin.readline().split()))

M = int(input())
targets = list(map(int, sys.stdin.readline().split()))

A.sort() 

for target in targets:
    start = 0
    end = N-1
    
    while start <= end:
        mid = (start + end) // 2

        if target == A[mid]:
            print(1)
            break
        elif A[mid] < target:
            start = mid + 1
        else:
            end = mid -1
    else:
        print(0)