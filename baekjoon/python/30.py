n = input()

if '0' not in n:
    print(-1)

else:
    n_num = 0
    for i in n:
        n_num += int(i)
    if n_num % 3 != 0:
        print(-1)
    else:
        sorted_num = sorted(n, reverse=True)
        print("".join(sorted_num))