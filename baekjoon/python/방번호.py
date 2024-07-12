N  = input()
data = ['0','1','2','3','4','5','6','7','8','9']
cnt = [0] * 10

for i in range(len(data)):
    cnt[i] = N.count(data[i])
print(cnt)

if cnt[6] >= 2 or cnt[9] >= 2:
    if (cnt[6] + cnt[9]) % 2 ==1:
        cnt[9] = (cnt[6] + cnt[9]) // 2 + 1
        cnt[6] = 0
    else: 
        cnt[9] = (cnt[6] + cnt[9]) // 2
        cnt[6] = 0

print(cnt)
        
print(max(cnt))