from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque({'index':i, 'value':e} for i, e in enumerate(priorities))
    while len(q) > 0:
        front = q.popleft()
        if len(q) > 0:
            my_max = max(map(lambda e: e['value'], q))
        else:
            my_max = 0
        if my_max > front['value']:
            q.append(front)
        else:
            answer += 1    
            if front['index'] == location:
                return answer 
    return -1

print(solution([2,1,3,2], 2))

print(sum([]))