from heapq import heappush, heappop
class Heap:
    def __init__(self):
        self.max_heap = []
        self.min_heap = []
        self.max_deleted = {}
        self.min_deleted = {}
    def push(self, number):
        heappush(self.max_heap, -number)
        heappush(self.min_heap, number)

    def pop_min(self):
        if len(self.min_heap) > 0:
            number = heappop(self.min_heap)
            while number in self.min_deleted:
                self.min_deleted[number] -= 1
                if self.min_deleted[number] == 0:
                    del self.min_deleted[number]
                if len(self.min_heap) > 0:    
                    number = heappop(self.min_heap)
                else:
                    return None
            if number in self.max_deleted:
                self.max_deleted[number] += 1
            else:
                self.max_deleted[number] = 1
            return number
        else:
            return None

    def pop_max(self):
        if len(self.max_heap) > 0:
            number = -heappop(self.max_heap)
            while number in self.max_deleted:
                self.max_deleted[number] -= 1
                if self.max_deleted[number] == 0:
                    del self.max_deleted[number]
                if len(self.max_heap) > 0:    
                    number = -heappop(self.max_heap)
                else:
                    return None
            if number in self.min_deleted:
                self.min_deleted[number] += 1
            else:
                self.min_deleted[number] = 1
            return number
        else:
            return None
    def max(self):
        number = self.pop_max()
        if number is not None:
            self.push(number)
        return number
    def min(self):
        number = self.pop_min()
        if number is not None:
            self.push(number)
        return number
def solution(operations):
    heap = Heap()
    for operation in operations:
        op, number = operation.split(' ')
        number = int(number)
        if op == 'I':
            heap.push(number)
        elif op == 'D':
            if number == 1:
                heap.pop_max()
            elif number == -1:
                heap.pop_min()
    min_number = heap.min()
    max_number = heap.max()
    if min_number is not None and max_number is not None:
        answer = [max_number, min_number]
    else:
        answer = [0,0]
    return answer