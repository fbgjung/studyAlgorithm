def solution(arr):
    stack = [] # stack
    stack.append(arr[0])
    for i in range(1,len(arr)):
        if stack[-1] == arr[i]:
            continue
        else: stack.append(arr[i])

    return stack

print(solution([1,1,3,3,0,1,1]))
print(solution([4,4,4,3,3]))