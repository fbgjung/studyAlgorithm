N = int(input())
error = N

while N > 0:
    word = input()
    
    for i in range(len(word)-1):
        if word[i] != word[i+1]:
            new_word = word[i+1:]
            if word[i] in new_word:
                error-=1
                break
    N-=1
                
print(error)