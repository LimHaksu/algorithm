def solution(a):
    answer = -1
    dic = {}
    for i in range(len(a)):
        dic[i] = []
    for i, num in enumerate(a):
        dic[num].append(i)
    
    for key in dic:
        count = 0
        used = {}
        for index in dic[key]:
            if index > 0 and index-1 not in used and index not in used and a[index] != a[index-1]:
                used[index-1] = True
                used[index] = True
                count += 2
            elif index < len(a)-1 and (index+1) not in used and index not in used and a[index] != a[index+1]:
                used[index+1] = True
                used[index] = True
                count += 2
        answer = max(answer, count)
    return answer

print(solution([5,2,3,3,5,3]))