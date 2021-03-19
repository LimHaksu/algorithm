from itertools import combinations
def solution(relation):
    answer = set()
    col_num = len(relation[0])
    # relation 에서 1개, 2개, ... n개 뽑기
    for num in range(1, col_num+1):
        for combi in combinations(range(col_num), num):
            # 뽑은애들의 인덱스 중에서 1개, 2개, ... m-1개 뽑기
            bk_check = False
            for num2 in range(1, len(combi)+1):
                for combi2 in combinations(combi, num2):
                    # 인덱스 뽑은애들로 연결해서 하나의 값으로 만들기
                    index_str = ','.join(map(str,combi2))
                    if index_str in answer:
                        bk_check = True
                        break
                # 인덱스 연결 값이 기존 set에 존재하면 최소성x -> 스킵
                if bk_check:
                    break
            # 인덱스 subset이 기존거에 없으면 뽑은걸 합쳐서 하나의 값으로 만들기
            if bk_check == False:
                is_duplicate = False
                row_set = set()
                for row in relation:
                    temp_str = ','.join(list(map(lambda e: str(e[1]),filter(lambda e: e[0] in combi, [(i, e) for i, e in enumerate(row)]))))
                    # 각 값이 중복되는지 set으로 검사
                    if temp_str in row_set:
                        is_duplicate = True
                        break
                    else:
                        row_set.add(temp_str)
                # 중복되는게 없으면 index set에 넣기
                if is_duplicate == False:
                    index_str = ','.join(map(str, combi))
                    answer.add(index_str)
    return len(answer)

print(solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]))