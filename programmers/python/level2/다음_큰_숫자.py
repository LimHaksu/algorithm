def solution(n):
    binary = to_binary_str_list(n)
    last_index = len(binary)-1
    left, right = 0, last_index
    find = False
    for i in range(last_index, -1, -1):
        if binary[i] == '1':
            if find == False:
                find = True
                right = i
                left = i
            else:
                left = i
        else:
            if find == True:
                break
    
    for i in range(left, left+1+last_index-right):
        binary[i] = '0'
    for i in range(left+1+last_index-right, last_index+1):
        binary[i] = '1'
    if left == 0:
        binary.insert(0, '1')
    else:
        binary[left-1] = '1'
    return to_decimal(binary)

def to_binary_str_list(n):
    s = ''
    while n > 0:
        s += str(n%2)
        n //= 2
    return [c for c in s[::-1]]

def to_decimal(binary_str_list):
    res = 0
    current = 1
    for i in range(len(binary_str_list)-1, -1, -1):
        res += current * int(binary_str_list[i])
        current *= 2
    return res

print(solution(78))