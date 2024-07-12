import sys
input = sys.stdin.readline()

M = int(input())

array = set()
for _ in range(M):
    command = input().split()

    if command[0] == "add":
        array.add(command[1])
    elif command[0] == "remove":
        if command[1] in array:
            array.remove(command[1])
        else: continue
    elif command[0] == "check":
        if command[1] in array: print(1)
        else: print(0)
    elif command[0] == "toggle":
        if command[1] in array: array.remove(command[1])
        else: array.add(command[1])
    elif command[0] == "all":
        array = set([i for i in range(1,21)])
    else: array = set()
