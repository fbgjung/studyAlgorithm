from collections import deque
import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    
    p = input()
    n = int(input())
    q = deque(input().rstrip()[1:-1].split(","))

    if n == 0:
        q = deque()

    flag = 0
    for t in p:
        if t == "R":
            q.reverse()
        elif t == "D":
            if q: q.popleft()
            else:
                print('error')
                flag = 1
                break

    if flag == 0:
        print("[" + ",".join(q) + "]")