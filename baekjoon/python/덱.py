from collections import deque
import sys

queue = deque()
N = int(input())

while N > 0:
    how = sys.stdin.readline().split()

    if how[0] == "push_back":
        queue.append(how[1])
    elif how[0] == "push_front":
        queue.appendleft(how[1])
    elif how[0] == "pop_front":
        if len(queue) == 0:
            print(-1)
        else: print(queue.popleft())
    elif how[0] == "pop_back":
        if len(queue) == 0:
            print(-1)
        else: print(queue.pop())
    elif how[0] == "size":
        print(len(queue))
    elif how[0] == "empty":
        if len(queue) == 0:
            print(1)
        else: print(0)
    elif how[0] == "front":
        if len(queue) == 0:
            print(-1)
        else: print(queue[0])
    else:
        if len(queue) == 0:
            print(-1)
        else: print(queue[-1])

    N-=1