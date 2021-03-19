def solution(n, t, m, p):
    answer = []
    string = ''
    current_num = 0
    while len(string) < t*m:
        string += make_nth_num(current_num, n)
        current_num += 1
    for i in range(p-1, p-1+t*m, m):
        answer.append(string[i])

    return ''.join(map(str,answer))


def make_nth_num(decimal, n):
    if decimal == 0:
        return '0'

    arr = []

    while decimal > 0:
        num = decimal % n
        if num > 9:
            num = chr(ord('A') + num - 10)
        arr.append(num)
        decimal //= n
    return ''.join(map(str, reversed(arr)))


print(solution(16,16,2,1))
