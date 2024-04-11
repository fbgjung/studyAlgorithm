# 백트래킹
l, c = map(int, input().split())

v = ['a','e','i','o','u'] 
words = input().split() 
words.sort()

def check(arr):
    v_cnt, c_cnt = 0, 0
    for a in arr:
        if a in v:
            v_cnt += 1
        else:
            c_cnt += 1
    
    if v_cnt >= 1 and c_cnt >= 2:
        return True
    else: 
        return False

def backtracking(s):
    if len(s) == l and check(s) == True:
        print(''.join(map(str,s)))
        return
    for i in range(c):
        if words[i] not in s and s[-1] < words[i]:
            s.append(words[i])
            backtracking(s)
            s.pop()

for i in range(c-l+1):
    a = [words[i]]
    backtracking(a)