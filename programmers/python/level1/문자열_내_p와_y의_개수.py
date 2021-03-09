def solution(s):
    countP = 0
    countY = 0
    for c in s:
        if c == 'p' or c == 'P':
            countP +=1 
        elif c == 'y' or c == 'Y':
            countY += 1
    return countP == countY