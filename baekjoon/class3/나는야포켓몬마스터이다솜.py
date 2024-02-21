N, M = map(int, input().split()) 

pocketmons = []
questions = []

for _ in range(N):
    pocketmons.append(input())

for _ in range(M):
    question = input()

    if question in pocketmons:
        print(pocketmons.index(question)+1)
    elif question not in pocketmons:
        question = int(question)
        print(pocketmons[question-1])
