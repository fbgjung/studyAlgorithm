def solution(n, times):
    answer = 0
    left = min(times)
    right = max(times) * n

    while left <= right:
        people = 0
        mid = (left + right) // 2
        for time in times:
            people += mid // time
            if people >= n:
                break

        if people >= n:
            answer = mid
            right = mid-1
        else:
            left = mid +1

    return answer

print(solution(6,[7,10]))

# 6명이 모두 심사를 받는데 걸리는 최소 시간