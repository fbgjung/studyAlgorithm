

N = int(input())


for _ in range(N):
    strings = input()
    stack = []

    for s in strings:
        if s == '(':
            stack.append(s)
        elif s == ')':
            if stack:
                stack.pop()
            else:
                stack.append(s)
                break

    if stack:
        print("NO")
    else:
        print("YES")