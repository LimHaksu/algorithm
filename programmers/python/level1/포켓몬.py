def solution(nums):
    kind_of_pocketmons = set()
    for n in nums:
        kind_of_pocketmons.add(n)
    return min(len(nums)/2, len(kind_of_pocketmons))