from collections import deque
def solution(people, limit):
    people = deque(people.sort())
    answer = 0
    while people:
        # 무거운 사람 한 명 뽑음
        heavy = people.pop()
        # 가벼운 사람 한 명 뽑음
        light = 0
        if len(people) > 0:
            light = people.popleft()
        # 합이 크면 무거운 사람만 태워 보냄
        if heavy + light > limit:
            people.appendleft(light)
        answer += 1
        
    return answer