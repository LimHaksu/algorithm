def solution(s):
    splited = s.split(' ')
    for i, word in enumerate(splited):
        arr = [c for c in word]
        if len(arr) > 0:
            arr[0] = arr[0].upper()
            for j in range(1, len(arr)):
                arr[j] = arr[j].lower()
            splited[i] = ''.join(arr)
    return ' '.join(splited)


print(solution('hi  bye'))