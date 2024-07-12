data = []
totalNum = 0
totalScore = 0
for i in range(20):
    data.append(list(map(str, input().split())))

for i in range(20):
    if data[i][2] == 'P':
        continue
    else:
        int_num = float(data[i][1])
        totalNum += int_num
        if data[i][2] == "A+": score = 4.5
        elif data[i][2] == "A0": score = 4.0
        elif data[i][2] == "B+": score = 3.5
        elif data[i][2] == "B0": score = 3.0
        elif data[i][2] == "C+": score = 2.5
        elif data[i][2] == "C0": score = 2.0
        elif data[i][2] == "D+": score = 1.5
        elif data[i][2] == "D0": score = 1.0
        else: score = 0.0
        totalScore += int_num * score

print(round((totalScore/totalNum),6))



