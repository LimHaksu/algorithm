def solution(skill, skill_trees):
    answer = 0
    for sk in skill_trees:
        index = 0
        check = True
        for c in sk:
            if c in skill:
                if c != skill[index]:
                    check = False
                    break
                else:
                    index += 1
        if check:
            answer += 1
    return answer