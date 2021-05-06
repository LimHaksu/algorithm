inf = 200_000_000
def solution(stones, k):
    answer = 0
    arr = [inf, *stones, inf]
    left = 1
    right = inf
    while left <= right:
        mid = (left + right) // 2
        if is_valid(arr, mid, k):
            answer = max(answer, mid)
            left = mid + 1
        else:
            right = mid - 1
    return answer

def is_valid(arr, h, k):
    index = 0
    while index < len(arr):
        count = 1
        while count <= k and index + count < len(arr):
            if arr[index + count] >= h:
                index += count
                break
            count += 1
        if count > k:
            return False
        if index == len(arr)-1:
            break
    return index == len(arr)-1

print(solution([2,4,5,3,2,1,4,2,5,1], 3))