def solution(n):
    # return int(''.join(map(str,sorted(map(int, [i for i in str(n)]), reverse=True))))
    ls = list(str(n))
    ls.sort(reverse=True)
    return int(''.join(ls))