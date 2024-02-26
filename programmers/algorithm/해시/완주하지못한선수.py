def solution(participant, completion):
    dic1={i:0 for i in participant}
    dic2={i:0 for i in participant}

    for p in participant:
        dic1[p] += 1

    for c in completion:
        dic2[c] += 1

    for i in dic1:
        if dic1[i] - dic2[i] == 1:
            return i

print(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]))