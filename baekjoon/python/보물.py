N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A = sorted(A,reverse=True)

sum = 0
for i in range(N):
    min_value = min(B)
    min_index = B.index(min_value)
    sum += (A[i] *  min_value)
    del B[min_index]
    
print(sum)