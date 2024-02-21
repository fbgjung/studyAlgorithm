# N, M = map(int, input().split()) 

# pocketmons = []
# questions = []

# for _ in range(N):
#     pocketmons.append(input())

# for _ in range(M):
#     question = input()

#     if question in pocketmons:
#         print(pocketmons.index(question)+1)
#     elif question not in pocketmons:
#         question = int(question)
#         print(pocketmons[question-1])

import sys
input = sys.stdin.readline

N, M = map(int, input().split()) 
pocketmons = {} 

for i in range(1, N+1):
    pocketmon = input().rstrip()
    pocketmons[i] = pocketmon
    pocketmons[pocketmon] = i


for _ in range(M):
    question = input().rstrip()
    if question.isdigit():
        print(pocketmons[int(question)])
    else:
        print(pocketmons[question])