def solution(phone_book):
    answer = True
    sort_phone_book = sorted(phone_book)

    for i in range(len(sort_phone_book)-1):
        first = sort_phone_book[i]
        second = sort_phone_book[i+1]

        firstLen = len(first)

        if first == second[:firstLen]:
            answer = False

    return answer

print(solution(["119", "97674223", "1195524421"]))
print(solution(["123","456","789"]))
print(solution(["12","123","1235","567","88"]))