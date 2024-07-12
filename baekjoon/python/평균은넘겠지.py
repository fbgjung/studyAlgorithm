C = int(input())

for _ in range(C):
    data = list(map(int, input().split()))
    num_scores = data[0]
    scores = data[1:]
    avg = sum(scores) / num_scores
    
    cnt = sum(1 for score in scores if score > avg)
    
    percentage = (cnt / num_scores) * 100
    
    print(f'{percentage:.3f}%')