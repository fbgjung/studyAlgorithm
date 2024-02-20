# ⭐

import math

def isPrime(x):
    if x < 2:
        return False
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0:
            return False
    return True
    
N = int(input())
numbers = list(map(int, input().split()))
count = 0

for number in numbers:
    if isPrime(number):
        count += 1

print(count)

                   