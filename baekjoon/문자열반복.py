test_case = int(input())

while test_case > 0:
    test_case -= 1
    cmd = input().split()

    for i in cmd[1]:
        print(i * int(cmd[0]), end='')
    print()
