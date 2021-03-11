def solution(s):
    s = s[1:-1]
    is_open = False
    num = 0
    my_set = set()
    set_list = []
    for c in s:
        if c == '{':
            is_open = True
            num = 0
            my_set = set()
        elif c == '}':
            is_open = False
            my_set.add(num)
            set_list.append(my_set)
        elif c == ',':
            if is_open:
                my_set.add(num)
                num = 0
        else:
            num = num* 10 + int(c)
    set_list.sort(key=lambda e: len(e))
    visited = set()
    answer = []
    for s in set_list:
        for num in s:
            if num not in visited:
                visited.add(num)
                answer.append(num)
    return answer

print(solution("{{2,1},{2},{2,1,3},{2,1,3,4}}"))