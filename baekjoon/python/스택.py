import sys

num = int(sys.stdin.readline())
stack=[]   

while num > 0:
    how = sys.stdin.readline().split()

    if how[0] == 'push':
        stack.append(how[1])
    elif how[0] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif how[0] == 'size':
        print(len(stack))
    elif how[0] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(stack) == 0:
            print(-1)
        else: print(stack[-1])
    
    num -= 1
