def solution(s):
    answer = ''
    for word in s.split(' '):
        for i, c in enumerate(word):
            if c.isalpha():
                if(i % 2 == 0):
                    answer += c.upper()
                else:
                    answer += c.lower()
            else:
                answer += c
        answer += ' '
    return answer[:-1]

print(solution("try1 hello world"))