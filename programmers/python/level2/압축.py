def solution(msg):
    answer = []
    dic = {}
    for i, code in enumerate(range(ord('A'), ord('Z')+1)):
        dic[chr(code)] = i + 1
    start_index = 0
    end_index = 0
    while start_index < len(msg):
        end_index = start_index
        current_str = msg[end_index]
        end_index += 1
        while current_str in dic and end_index < len(msg):
            current_str += msg[end_index]
            end_index += 1
        if current_str not in dic:
            answer.append(dic[current_str[0:-1]])
            dic[current_str] = len(dic) + 1
            end_index -= 1
        else:
            answer.append(dic[current_str])
        start_index = end_index
    return answer

print(solution('KAKAO'))