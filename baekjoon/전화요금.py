n = int(input())
result = 0

for i in range(n):
    start, dd = map(str, input().split())
    start_h = int(start[0:2])
    start_m = int(start[3:6])
    dd = int(dd)

    end_h, end_m = start_h, 0

    if start_m + dd >= 60:
        end_m = start_m + dd - 60
        end_h = start_h +1
        if end_h > 23:
            end_h = 0
    else:
        end_m = start_m + dd
        
    if 7 <= start_h <= 18:
        if end_h == 19:
            result += (60-start_m) * 10 + end_m * 5
        else:
            result += dd * 10
            
    if 0 <= start_h <= 7 or 19 <= start_h <= 23:
        if end_h == 7:
            result += (60-start_m) * 5 + end_m * 10
        else:
            result += dd * 5
        
print(result)