def solution(sizes):
    answer = 0

    for size in sizes:
        if size[0] < size[1]:
            size[0], size[1] = size[1], size[0]

    X = max(size[0] for size in sizes)
    Y = max(size[1] for size in sizes)

    answer = X * Y
    return answer

print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))