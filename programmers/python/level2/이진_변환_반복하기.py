def solution(s):
    count = 0
    removed_zeros = 0
    while True:
        prev_len = len(s)
        s = s.replace('0', '')
        count += 1
        removed_zeros += prev_len - len(s)
        if s == '1':
            break
        s = to_binary_str(len(s))
    return [count, removed_zeros]

def to_binary_str(n):
    s = ''
    while n > 0:
        s += str(n % 2)
        n //= 2
    return s[::-1]

print(solution('110010101001'))
