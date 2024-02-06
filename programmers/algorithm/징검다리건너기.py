def solution(stones, k):
    left = 1
    right =  200000000
    
    while left <= right:
        temp=stones.copy()
        mid = (left + right) // 2
        count = 0
        for i in temp:
            if i <= mid:
                count += 1
            else:
                count = 0
            if count >= k:
                break
            
        if count >= k:
            right = mid-1
        else:
            left = mid + 1
    return left

print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1],3))