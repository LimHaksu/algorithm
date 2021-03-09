def solution(participant, completion):
    s = {}
    for c in completion:
        if c in s:
            s[c] += 1
        else:
            s[c] = 1
    for p in participant:
        if p not in s:
            return p
        else:
            s[p] -= 1
            if s[p] == 0:
                del s[p]
    return ''