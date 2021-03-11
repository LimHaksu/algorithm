def solution(dirs):
    path_set = set() # from-to, to-from 둘 다 저장. 마지막에 2로 나눠야함
    r, c = 0, 0
    for dir in dirs:
        nrc = next_rc(r,c,dir)
        nr,nc = nrc[0], nrc[1]
        if -5 <= nr <= 5 and -5 <= nc <= 5:
            path_set.add((r,c,nr,nc))
            path_set.add((nr,nc,r,c))
            r, c = nr, nc
    return len(path_set) // 2

def next_rc(r, c, d):
    direction = {
        'L' : (0, -1),
        'R' : (0, 1),
        'U' : (1, 0),
        'D' : (-1, 0)
    }
    return [r + direction[d][0], c + direction[d][1]]

print(solution('ULURRDLLU'))