class Node:
    def __init__(self, start, end):
        self.start = start
        self.end = end
    def __lt__(self, other):
        if self.end < other.end:
            return True
        elif self.end > other.end:
            return False
        if self.start < other.start:
            return True
        return False

from collections import deque
def solution(lines):
    answer = 0
    nodes = []
    for l in lines:
        end, duration = time_to_int(l)
        start = end - duration + 1
        nodes.append(Node(start, end))
    nodes.sort()
    dq = deque()
    for i in range(len(nodes)):
        count = 0
        current = nodes[i]
        for j in range(i, len(nodes)):
            node = nodes[j]
            if current.end + 1000 > node.start:
                count += 1
        answer = max(answer, count)
    return answer

def time_to_int(string):
    _, hms, d = string.split(' ')
    hour, minute, second = map(lambda num: int(float(num)*1000),hms.split(':'))
    duration = int(float(d[:-1]) * 1000)
    time = hour * 60 * 60 + minute * 60 + second
    return time, duration