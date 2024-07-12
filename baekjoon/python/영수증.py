# 영수증에 적힌 총 금액 X
# 영수증에 적힌 구매한 물건의 종류의 수 N
# 각 물건의 가격 a와 개수 b가 공백을 사이에 두고 주어진다.

# X와 일치하면 Yes


X = int(input())
N = int(input())

total = 0
array = []

for _ in range(N):
    a,b = list(map(int, input().split()))
    array.append([a,b])

for i in range(N):
    total += array[i][0] * array[i][1]
print(total)



# print(sum)

# if X == sum:
#     print('Yes')
# else:
#     print('No')

