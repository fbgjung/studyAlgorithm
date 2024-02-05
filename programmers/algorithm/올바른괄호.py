def solution(s):
    answer = True
    stack = []

    for i in s:
        if i == '(': stack.append(i)
        else:
            if stack == []:
                return False
            stack.pop()
    
    
    if stack == []: answer = True
    else: answer = False
    
    return answer

print(solution("()()"))
print(solution(")()("))
print(solution("(()("))