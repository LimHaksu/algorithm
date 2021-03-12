from collections import deque
def solution(cacheSize, cities):
    answer = 0
    cache = deque()
    for city in cities:
        city.lower()
        if is_hit(cache, city):
            answer += 1
        else:
            answer += 5
            if cacheSize > 0:
                if len(cache) >= cacheSize:
                    cache.popleft()
                cache.append(city)
    return answer

def is_hit(cache, city):
    if city in cache:
        cache.remove(city)
        cache.append(city)
        return True
    return False
    