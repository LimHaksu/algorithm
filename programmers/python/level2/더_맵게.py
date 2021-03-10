import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while True:    
        one = heapq.heappop(scoville)
        if one >= K:
            return answer
        if len(scoville) == 0:
            return -1
        two = heapq.heappop(scoville)
        new = one + two * 2
        heapq.heappush(scoville, new)
        answer += 1

print(solution([1,2,3,9,10,12],7))