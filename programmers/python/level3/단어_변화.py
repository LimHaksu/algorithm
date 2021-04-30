from collections import deque
def solution(begin, target, words):
    current = begin
    q = deque([current])
    count = -1
    words_set = set()
    for word in words:
        words_set.add(word)
    visited = set()
    visited.add(current)
    while len(q) > 0:
        qsize = len(q)
        count += 1
        for i in range(qsize):
            current = q.popleft()
            if current == target:
                return count
            for word in words:
                if calc_diff(word, current) == 1 and word not in visited:
                    visited.add(word)
                    q.append(word)
    return 0

def calc_diff(a, b):
    count = 0
    for i in range(len(a)):
        if a[i] != b[i]:
            count += 1
    return count

print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))