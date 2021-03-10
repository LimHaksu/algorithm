def solution(p):
    # 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
    if p == '':
         return ''
    # 2. 문자열 w를 균형잡힌 괄호 문자열 u,v로 분리, u는 가장 작게 해야함, v는 빈 문자열일수 있음
    index = len(p)-1
    count = [0,0]
    for i in range(len(p)):
        c = p[i]
        if c == '(':
            count[0] +=1
        else:
            count[1] +=1
        if count[0] == count[1]:
            index = i
            break
    u, v = p[:index+1], p[index+1:]
    # 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
    if is_right(u):
    #   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
        return u + solution(v)
    # 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    else:
    #   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
        temp = '(' 
    #   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        temp += solution(v) 
    #   4-3. ')'를 다시 붙입니다.
        temp += ')' 
    #   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        for c in u[1:-1]:
            if c == '(':
                temp += ')'
            else:
                temp += '('
    #   4-5. 생성된 문자열을 반환합니다.
        return temp

def is_right(p):
    top = -1
    for c in p:
        if c == '(':
            top += 1
        else:
            if top < 0:
                return False
            top -= 1
    return top == -1

print(solution("(()())()"))