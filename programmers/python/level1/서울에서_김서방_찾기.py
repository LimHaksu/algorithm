# def solution(seoul):
#     answer = ['김서방은 ', '', '에 있다']
#     answer[1] = str(seoul.index('Kim'))
#     return "".join(answer)

def solution(seoul):
    return "김서방은 {}에 있다".format(seoul.index('Kim'))

print(solution(["Jane", "Kim"]))