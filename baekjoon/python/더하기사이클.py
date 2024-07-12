begin = int(input())
target = begin
count = 0

while True:
    first = target // 10 
    second = target % 10 

    temp  = first + second 
    target = (second * 10) + (temp % 10)

    count += 1

    if target == begin:
        break
    
print(count)