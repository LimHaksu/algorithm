def solution(answers):
    result = []
    count = [0,0,0]
    answer2 = [1,3,4,5]
    answer3 = [3,1,2,4,5]
    for i, answer in enumerate(answers):
        # 1번 1,2,3,4,5
        if i%5+1 == answer:
            count[0] += 1
        # 2번 짝수 2, 홀수 1,3,4,5
        if i%2==0 and answer == 2:
            count[1] += 1
        elif i%2==1 and answer2[(i//2)%4] == answers[i]:
            count[1] += 1
        # 3번 33 11 22 44 55
        if answer3[(i//2)%5] == answers[i]:
            count[2] += 1
    # 가장 높은 사람 찾기
    max = 0
    for i, c in enumerate(count):
        if c > max:
            max = c
            result = [i+1]
        elif c == max:
            result.append(i+1)

    return sorted(result)

print(solution([1,2,3,4,5]))