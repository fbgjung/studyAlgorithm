# import sys
# input = sys.stdin.readline

# N = int(input())
# array = list(map(int, input().split()))
# result = []

# set_array = sorted(list(set(array)))

# for i in array:
#     result.append(set_array.index(i))

# for i in range(N):
#     print(result[i], end=' ')


import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int, input().split()))

set_array = sorted(list(set(array)))

dic = {set_array[i]: i for i in range(len(set_array))}

for i in array:
    print(dic[i], end = ' ')