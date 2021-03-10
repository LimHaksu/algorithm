def solution(progresses, speeds):
    answer = []
    arr = []
    for i in range(len(progresses)):
        amount = (100-progresses[i])
        days = amount // speeds[i]
        if amount % speeds[i] != 0:
            days += 1
        arr.append(days)
    pmax = 0
    for i in range(len(arr)):
        if pmax < arr[i]:
            pmax = arr[i]
        arr[i] = pmax
    count = 1
    for i in range(1,len(arr)):
        if arr[i] != arr[i-1]:
            answer.append(count)
            count = 1
        else:
            count += 1
    answer.append(count)
    return answer