def solution(s):
    arr = map(int,s.split(' '))
    return [min(arr), max(arr)]