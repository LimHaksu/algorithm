from itertools import combinations
def solution(orders, course):
    answer = []
    dic = {}
    for num in course:
        for order in orders:
            for combi in combinations(order, num):
                key = ''.join(sorted(combi))
                if key in dic:
                    dic[key] += 1
                else:
                    dic[key] = 1
    dic_for_ans = {}
    for key in dic:
        if dic[key] >= 2:
            if len(key) in dic_for_ans:
                if dic_for_ans[len(key)][0]['count'] < dic[key]:
                    dic_for_ans[len(key)] = [{'count': dic[key], 'word': key}]
                elif dic_for_ans[len(key)][0]['count'] == dic[key]:
                    dic_for_ans[len(key)].append({'count': dic[key], 'word': key})
            else:
                dic_for_ans[len(key)] = [{'count': dic[key], 'word': key}]

    for length in dic_for_ans:
        for e in dic_for_ans[length]:
            answer.append(e['word'])
    return sorted(answer)

print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))