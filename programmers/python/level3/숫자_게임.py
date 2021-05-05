def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    b_index = 0
    for a_num in A:
        while b_index < len(B) and B[b_index] <= a_num:
            b_index += 1
        if b_index >= len(B):
            break
        answer += 1
        b_index += 1
    return answer

print(solution([5,1,3,7], [2,2,6,8]))