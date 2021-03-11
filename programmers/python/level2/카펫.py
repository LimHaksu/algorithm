def solution(brown, yellow):
    for h in range(1, 2500):
        if (brown/2-h)*(h-2) == yellow:
            w = (brown+4)/2 - h
            return [w, h]
    return [-1,-1]