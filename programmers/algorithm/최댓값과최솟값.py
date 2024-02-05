def solution(s):
    temp = list(map(int, s.split(' ')))
    maxnum = max(temp)
    minnum = min(temp)
    answer = [str(minnum), str(maxnum)]
    
    return ' '.join(answer)

print(solution("1 2 3 4"))