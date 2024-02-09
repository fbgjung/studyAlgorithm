K = int(input())
stack=[]
for _ in range(K):
    number = int(input())
    if number == 0:
        stack.pop()
    else:
        stack.append(number)
print(stack)
sum = 0
for i in range(len(stack)):
    sum += stack[i]    
print(sum)  