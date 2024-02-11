N = int(input())

data = []

for _ in range(N):
    age, name = input().split()
    data.append([int(age),name])

sort_data = sorted(data, key = lambda x: x[0])

for user in sort_data:
    print(user[0],user[1])