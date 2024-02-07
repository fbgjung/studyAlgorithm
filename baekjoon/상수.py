numbers = input().split()

array = []

for number in numbers:
    
    # ⭐문자열 뒤집고, 다시 문자열로 변환하여 리스트에 추가
    print(reversed(number)) # <reversed object at 0x0000020D9066B670>
    array.append(''.join(reversed(number))) 

print(max(map(int, array)))