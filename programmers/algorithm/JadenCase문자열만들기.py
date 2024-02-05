def solution(s):
    temp = s.split(" ")
    result=[]

    for i in temp :
        result.append(i.capitalize())

    return ' '.join(result)

print(solution("3people unFollowed me"))
print(solution("for the last week"))