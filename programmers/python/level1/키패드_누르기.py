position = {
        1 : [0,0],
        2 : [0,1],
        3 : [0,2],
        4 : [1,0],
        5 : [1,1],
        6 : [1,2],
        7 : [2,0],
        8 : [2,1],
        9 : [2,2],
        '*' : [3,0],
        0 : [3,1],
        '#' : [3,2]
    }
def solution(numbers, hand):
    answer = ''
    pos = {
        'left' : '*',
        'right' : '#'
    }
    for num in numbers:
        if num in (1,4,7):
            answer += 'L'
            pos['left'] = num
        elif num in (3,6,9):
            answer += 'R'
            pos['right'] = num
        else:
            left_diff = get_diff(pos['left'], num)
            right_diff = get_diff(pos['right'], num)
            print(left_diff, right_diff)
            if left_diff < right_diff:
                answer += 'L'
                pos['left'] = num
            elif left_diff > right_diff:
                answer += 'R'
                pos['right'] = num
            else:
                if hand == 'left':
                    answer += 'L'
                    pos['left'] = num
                else:
                    answer += 'R'
                    pos['right'] = num
    return answer

def get_diff(num1, num2):
    pos1 = position[num1]
    pos2 = position[num2]
    return abs(pos1[0]-pos2[0]) + abs(pos1[1] - pos2[1])


print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'))