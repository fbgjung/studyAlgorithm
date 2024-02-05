def solution(brown, yellow):
    answer = []
    
    for i in range(1,yellow+1):
        if yellow % i == 0:
            yellowX = int(yellow/i)
            yellowY = i
            if (2 * (yellowX + yellowY) + 4  == brown):
                answer.append(yellowX+2)
                answer.append(yellowY+2)
                break

    return answer

print(solution(24,24))