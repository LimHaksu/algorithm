def solution(s):
    answer = len(s)
    for i in range(1,len(s)):
        res = shorten(s, i)
        if len(res) < answer:
            answer = len(res)
    return answer

def shorten(s, length):
    arr = []
    for i in range(0, len(s), length):
        word = ''
        for j in range(i, min(i+length, len(s))):
            word += s[j]
        arr.append(word)
    
    res = ''
    count = 1
    prev_word = arr[0]
    for i in range(1,len(arr)):
        if arr[i] == prev_word:
            count += 1
        else:
            res += (str(count) if count > 1 else '') + prev_word
            prev_word = arr[i]
            count = 1
    res += (str(count) if count > 1 else '') + prev_word
    return res

print(solution("abcabcdede"))