def solution(s):
    answer = 0
    for i in range(len(s)):
        start = i-1
        end = i+1
        count = 1
        while start >= 0 and end < len(s) and s[start] == s[end]:
            count += 2
            start -= 1
            end += 1
        answer = max(answer, count)
    for i in range(len(s)):
        start = i
        end = i+1
        count = 0
        while start >= 0 and end < len(s) and s[start] == s[end]:
            count += 2
            start -= 1
            end += 1
        answer = max(answer, count)
    return answer

print(solution(	"abcdcba"))