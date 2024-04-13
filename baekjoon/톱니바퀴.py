import collections

s = []
for _ in range(4):
    s.append(collections.deque(list(input())))
k = int(input())
r = [list(map(int, input().split())) for _ in range(k)] # [3,1][1,-1]

def left(num, direction):
    if num < 0:
        return
    if s[num][2] != s[num+1][6]:
        left(num-1, -direction)
        s[num].rotate(direction)
def right(num, direction):
    if num > 3:
        return
    if s[num][6] != s[num-1][2]:
        right(num+1, -direction)
        s[num].rotate(direction)

for i in range(k):
    num = r[i][0] - 1
    direction = r[i][1]
    left(num-1, -direction)
    right(num+1, -direction)

    # 현재 톱니바퀴 회전
    s[num].rotate(direction)

res = 0
if s[0][0] == '1':
    res += 1
if s[1][0] == '1':
    res += 2
if s[2][0] == "1":
    res += 4
if s[3][0] == "1":
    res += 8
print(res)