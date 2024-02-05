from itertools import permutations

def isPrime(number):
    if(number < 2):
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if(number % i == 0):
            return False
    return True

def solution(numbers):
    answer = 0
    result_set = set()

    for number in range(len(numbers)):
        permuted_list = list(permutations(list(numbers), number+1))
        for permuted_num in permuted_list:
            result_set.add(int(''.join(permuted_num)))
    
    for num in result_set:
        if(isPrime(num)):
            answer += 1

    return answer

print(solution("17"))
print(solution("011"))