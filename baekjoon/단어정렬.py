N = int(input())
data = [[] for _ in range(51)] 

for _ in range(N):
    S = input()
    data[len(S)].append(S)
    
for words in data:
    new_words = sorted(set(words))
    for word in new_words:
        print(word)