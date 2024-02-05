def solution(N, number):

    dp = [set() for _ in range(9)]

    for i in range(1, 9):
        dp[i].add(int(str(N) * i))

    for i in range(1,9):
        for j in range(1, i):
            for num1 in dp[j]:
                for num2 in dp[i - j]:
                    dp[i].add(num1 + num2)
                    dp[i].add(num1 - num2)
                    dp[i].add(num1 * num2)
                    if num2 != 0:
                        dp[i].add(num1 // num2)

        if number in dp[i]:
            answer =  i
            break
        answer = -1

    return answer