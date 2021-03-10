def solution(n):
    third = changeTo3(n)
    for index in range(len(third)-1, -1, -1):
        if third[index] == '0':
            if index == 0:
                third = ''.join(third[1:])
            else:
                third = ''.join((third[:index], '4', third[index+1:]))
                third = decrease(third, index-1)
    return third

def decrease(string, index):
    next_num = int(string[index])-1
    if next_num == -1:
        next_num = 2
        string = decrease(string, index-1)
    string = ''.join((string[:index], str(next_num), string[index+1:]))
    return string
    
def changeTo3(n):
    s = ''
    while n > 0:
        s += str(n % 3)
        n //= 3
    return ''.join(reversed(s))

print(solution(3))