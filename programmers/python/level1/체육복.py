def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    availables = [True for i in range(n+1)]
    remain = []
    # 잃어버림
    for index in lost:
        availables[index] = False
        
    # 본인이 잃어버렸으면 본인이 씀
    for index in reserve:
        if availables[index] == False:
            availables[index] = True
        else:
            remain.append(index)
            
    # 앞 뒤로 빌려줄 수 있으면 빌려줌
    for index in remain:
        if index > 1 and availables[index-1] == False:
            availables[index-1] = True
        elif index < n and availables[index+1] == False:
            availables[index+1] = True
    return len(list(filter(lambda x:x == True, availables[1:])))
    
print(solution(5,[2,4],[1,3,5]))