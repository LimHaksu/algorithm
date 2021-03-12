from math import floor
import re
def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    arr1, arr2 = [], []
    p = re.compile('[a-zA-Z]{2}')
    for i in range(len(str1)-1):
        word = str1[i:i+2]
        if p.match(word):
            arr1.append(word)
    for i in range(len(str2)-1):
        word = str2[i:i+2]
        if p.match(word):
            arr2.append(word)
    return calcJ(arr1, arr2)

def calcJ(arr1, arr2):
    if len(arr1) == 0 and len(arr2) == 0:
        return 65536
    intersection = []
    union = []
    i1, i2 = 0, 0
    arr1.sort()
    arr2.sort()
    while i1 < len(arr1) and i2 < len(arr2):
        if arr1[i1] == arr2[i2]:
            intersection.append(arr1[i1])
            union.append(arr1[i1])
            i1 += 1
            i2 += 1
        else:
            if arr1[i1] < arr2[i2]:
                union.append(arr1[i1])
                i1 += 1
            else:
                union.append(arr2[i2])
                i2 += 1
    while i1 < len(arr1):
        union.append(arr1[i1])
        i1 += 1
    while i2 < len(arr2):
        union.append(arr2[i2])
        i2 += 1
    return floor(65536 * len(intersection) / len(union))

print(solution('FRANCE', 'french'))
