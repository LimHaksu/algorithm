def solution(phone_book):
    phone_book.sort()
    answer = True
    phone_set = set()
    # 각 문자열에 대하여
    flag = False
    for phone in phone_book:
        # 앞에서부터 1자리 2자리... n자리에 대하여
        for i in range(1,len(phone)+1):
            # set에 있으면 False
            if phone[:i] in phone_set:
                answer = False
                flag = True
                break
        phone_set.add(phone) 
        if flag:
            break

    return answer