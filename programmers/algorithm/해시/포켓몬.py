# def solution(nums):
#     answer = 0
#     choice = len(nums) // 2 
#     set_nums = list(set(nums))

#     if len(set_nums) >= choice:
#         answer = choice
#     else:
#         answer = len(set_nums)
#     return answer


# other solution
def solution(nums):
    return min(len(set(nums)), len(nums)//2)