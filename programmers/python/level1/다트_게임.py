def solution(dartResult):
    scores = [0,0,0]
    index = -1
    i = 0
    while i < len(dartResult):
        c = dartResult[i]
        if c >= '0' and c <= '9':
            index += 1
            scores[index] = int(c)
            if c == '1' and i < len(dartResult)-1 and dartResult[i+1] >= '0' and dartResult[i+1] <='9':
                scores[index] *= 10
                scores[index] += int(dartResult[i+1])
                i += 1
        elif c == 'D':
            scores[index] **= 2
        elif c == 'T':
            scores[index] **= 3
        elif c == '*':
            scores[index] *= 2
            if index > 0:
                scores[index-1] *= 2
        elif c == '#':
            scores[index] *= -1
        i += 1
    return sum(scores)

print(solution('1S2D*3T'))
print(solution('1D2S#10S'))
print(solution('1D2S0T'))
print(solution('1S*2T*3S'))
print(solution('1D#2S*3S'))
print(solution('1T2D3D#'))
print(solution('1D2S3T*'))