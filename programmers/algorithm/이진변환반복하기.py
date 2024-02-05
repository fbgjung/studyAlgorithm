def solution(s):
    count = 0
    zero = 0

    while True:
        if s == '1':
            break

        zero += s.count('0')
        s = s.replace('0','')
        s = bin(len(s)).replace('0b','')

        count += 1

    answer = [count, zero]

    return answer

print(solution("110010101001"))