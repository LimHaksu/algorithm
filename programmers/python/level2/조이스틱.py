answer = 987654321
def solution(name):
    dfs(0,'A'*len(name), name,0)
    return answer

def dfs(index, string, name, count):
    diff = get_diff('A', name[index])
    count += diff
    string = string[:index]+name[index]+string[index+1:]
    if string == name:
        global answer
        if count < answer:
            answer = count
        return
    
    next = left_move(index-1, string, name)
    dfs(next[0], string , name, count+next[1])

    next = right_move(index+1, string, name)
    dfs(next[0], string , name, count+next[1])

def left_move(index, string, name):
    count = 1
    if index < 0:
        index += len(string)
    while string[index] == name[index] and count < len(string):
        index -= 1
        count += 1
        if index < 0:
            index += len(string)
    return (index, count)

def right_move(index, string, name):
    count = 1
    if index >= len(string):
        index = 0
    while string[index] == name[index] and count < len(string):
        index += 1
        count += 1
        if index >= len(string):
            index = 0
    return (index, count)

def get_diff(a, b):
    if a > b:
        a,b = b,a
    diff1 = ord(b)-ord(a)
    diff2 = ord(a)+26 - ord(b)
    return min(diff1, diff2)

print(solution('JAN'))