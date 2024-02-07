A = int(input())
B = int(input())
C = int(input())

number = A * B * C
str_number = str(number)

targets = '0123456789'

for target in targets:
    if target in str_number: print(str_number.count(target))
    else: print(0)
