def solution(s):
    answer = []
    splited = s[2:-2].split('},{')
    arr = []
    for string in splited:
        arr.append(list(map(int,string.split(','))))
    arr.sort(key=lambda e: len(e))
    used_set = set()
    for nums in arr:
        for num in nums:
            if num not in used_set:
                used_set.add(num)
                answer.append(num)
    return answer

print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))