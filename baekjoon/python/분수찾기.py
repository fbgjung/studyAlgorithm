n = int(input())
line = 1

while n > line:
    n -= line
    line += 1

if line % 2 == 0:
    up = n
    down = line - n + 1

else:
    up = line - n + 1
    down = n

print(str(up) + '/' + str(down))
print(up,'/',down, sep='') # sep="" 공백 없이 출력
