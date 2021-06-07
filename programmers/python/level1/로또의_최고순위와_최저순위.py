def solution(lottos, win_nums):
    win_set = set()
    for num in win_nums:
        win_set.add(num)
    min_count = 0
    zero_count = 0
    for num in lottos:
        if num in win_set:
            min_count += 1
        elif num == 0:
            zero_count += 1
    rank = [6,6,5,4,3,2,1]
    return [rank[min_count+zero_count],rank[min_count]]