from collections import deque

def solution(priorities, location):
    answer = 0
    queue = deque(priorities)
    targets = deque()

    for i in range(len(queue)):
        targets.append(i)
    
    while location in targets:
        check = False
        x = queue.popleft()
        y = targets.popleft()

        for q in queue:
            if x < q:
                queue.append(x)
                targets.append(y)
                check = True
                break
        
        if check == False:
            answer += 1
                
    return answer

print(solution([2, 1, 3, 2], 2))
print(solution([1, 1, 9, 1, 1, 1], 0))