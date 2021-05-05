class Node:
    def __init__(self):
        self.profit = 0
        self.parent = None

def solution(enroll, referral, seller, amount):
    dic = {}
    arr = []
    for name in enroll:
        dic[name] = Node()
        arr.append(dic[name])
    for i, p in enumerate(referral):
        if p != '-':
            arr[i].parent = p
    for i, name in enumerate(seller):
        distribute(name, dic, amount[i])
    answer = []
    for i in range(len(arr)):
        answer.append(arr[i].profit)
    
    return answer

def distribute(name, dic, amount):
    remain = amount * 100
    while name:
        next_money = int(remain * 0.1)
        dic[name].profit += remain - next_money
        name = dic[name].parent
        remain = next_money