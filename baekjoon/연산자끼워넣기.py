n = int(input())
a = list(map(int, input().split()))
op = list(map(int, input().split()))
minR, maxR = 1e9, -1e9

def backtracking(d, total, plus, minus, multiply, divide):
    global minR, maxR

    if d == n:
        minR = min(total, minR)
        maxR = max(total, maxR)
        return
    
    if plus:
        backtracking(d+1, total + a[d], plus - 1, minus, multiply, divide)
    if minus:
        backtracking(d+1, total - a[d], plus, minus - 1, multiply, divide)
    if multiply:
        backtracking(d+1, total * a[d], plus, minus, multiply - 1, divide)
    if divide:
        backtracking(d+1, int(total / a[d]), plus, minus, multiply, divide - 1)

backtracking(1, a[0], op[0], op[1], op[2], op[3])
print(maxR)
print(minR)