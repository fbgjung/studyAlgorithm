data = []

for _ in range(5):
    S = input()
    data.append(S)


for j in range(15):
    for i in range(5):
        # if j < len(data[i]):
        print(data[i][j], end='')
        