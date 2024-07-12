import sys
input = sys.stdin.readline

S = input()

prev = S[0]
zero = 0
one = 0

for i in range(1,len(S)):
    
    if prev != S[i]:
        if prev == '0':
            zero += 1
        else:
            one += 1
        
        prev = S[i]

# if prev == '0':
#     zero += 1
# else:
#     one += 1

print(min(zero, one))