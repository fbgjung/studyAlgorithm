import sys
input = sys.stdin.readline

n,m = map(int, input().split())

dict1 = dict()
count = 0

for _ in range(n):
    s = input().rstrip()
    dict1[s] = 1

for _ in range(m):
    target = input().rstrip()
    if target in dict1:
        count += 1
    
print(count)

# other solution
# import sys
# input = sys.stdin.readline
# n, m = map(int, input().split())
# s = [input() for _ in range(n)]
# targets = [input() for _ in range(m)]
# set_targets = set(targets)
# print(sum(1 for target in targets if target in s))