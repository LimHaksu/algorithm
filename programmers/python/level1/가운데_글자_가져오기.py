def solution(s):
    l = len(s)
    mid = l // 2
    if l % 2 == 0:
        answer = s[mid-1:mid+1]
    else:
        answer = s[mid]
    return answer