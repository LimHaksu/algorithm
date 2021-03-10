class Obj:
    def __init__(self, num):
        self.num = num
    def __lt__(self, other):
        sum1 = int(str(self.num) + str(other.num))
        sum2 = int(str(other.num) + str(self.num))
        if sum1 > sum2:
            return True
        else:
            return False

def solution(numbers):
    arr = [Obj(num) for num in numbers]
    arr.sort()
    return ''.join(map(lambda e: str(e.num) , arr))

print(solution([0,0]))