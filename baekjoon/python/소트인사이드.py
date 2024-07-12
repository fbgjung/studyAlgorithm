N = input()
array =[]
for n in N:
    array.append(n)

array = sorted(array, reverse=True)
print("".join(array))