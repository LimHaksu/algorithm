from collections import deque
def solution(prices):
    st = deque()
    answer = [0 for i in range(len(prices))]
    for i, p in enumerate(prices):
        if len(st) == 0:
            st.append({'index': i, 'value': p})
        else:
            while len(st) > 0 and st[-1]['value'] > p:
                top = st.pop()
                answer[top['index']] = i - top['index']
            st.append({'index': i, 'value': p})
    while len(st) > 0:
        top = st.pop()
        answer[top['index']] = len(answer) - 1 - top['index']
    return answer

print(solution([1,2,3,2,3]))