numbers = []
for _ in range(5):
    numbers.append(int(input()))


numbers.sort()

avg = (sum(i for i in numbers)) // 5
print(avg)
print(numbers[2])