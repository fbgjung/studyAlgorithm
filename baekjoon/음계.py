target = list(map(int, input().split()))

if target == sorted(target):
    print("ascending")
elif target == sorted(target, reverse=True):
    print("descending")
else:
    print("mixed")