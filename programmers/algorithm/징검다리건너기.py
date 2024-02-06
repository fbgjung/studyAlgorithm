def solution(stones, k):
    answer = 0
    
    while True:
        answer += 1
        stones = [stone - 1 for stone in stones]
        count = 0
        for stone in stones:
            if stone <= 0:
                count +=1
                if count == k:
                    return answer                   
            else:
                count = 0

print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1],3))