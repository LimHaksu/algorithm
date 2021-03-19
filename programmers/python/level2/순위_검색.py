from itertools import combinations
import copy
def solution(infos, queries):
    category_dic = {}
    for lang in ['cpp', 'java', 'python', '-']:
        for position in ['backend', 'frontend', '-']:
            for career in ['junior', 'senior', '-']:
                 for food in ['chicken', 'pizza', '-']:
                     category_dic[','.join([lang, position, career, food])] = []
    for info in infos:
        splited = info.split(' ')
        for num in range(5): # - 로 대체하는 개수
            for combi in combinations(range(4), num):
                c_splited = copy.deepcopy(splited[:4])
                for i in combi:
                    c_splited[i] = '-'
                
                lang = c_splited[0]
                position = c_splited[1]
                career = c_splited[2]
                food = c_splited[3]
                score = int(splited[4])
                category_dic[','.join([lang, position, career, food])].append(score)
    
    for key in category_dic:
        category_dic[key].sort()
        
    answer = []
    for query in queries:
        splited = query.split(' ')
        lang = splited[0]
        position = splited[2]
        career = splited[4]
        food = splited[6]
        score = int(splited[7])
        key = ','.join([lang, position, career, food])
        arr = category_dic[key]
        index = find_lower_bound(arr, score)
        if index == -1:
            num_of_people = 0
        else:
            num_of_people = len(arr) - index
        answer.append(num_of_people)
    return answer

def find_lower_bound(arr, num):
    left = 0
    right = len(arr)-1
    find = -1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] >= num:
            find = mid
            right = mid - 1
        else:
            left = mid + 1
    return find

print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"],
    ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))