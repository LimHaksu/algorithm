### 파이썬 알고리즘용 도구들...

## Array

```python
// n행 m열 배열 생성
arr = [[0 for j in range(m)] for i in range(n)]
```

## set

```python
const my_set = set();

my_set.add(e);

my_set.remove(e);

if e in my_set:
    # todo...

if e not in my_set:
	# todo...

for e in my_set:
    # todo...
    
len(my_set)
```

## map

```python
my_map = {}

my_map[key] = value

a = my_map[key]

if key in my_map:
    # todo...

if key not in my_map:
    # todo...

for key in my_map:
    # todo..
    
len(my_map)
```

## stack

```python
from collections import deque
stack = deque()

stack.append(e)

top = stack.pop()

top = stack[-1]

len(stack)
```

## queue

```python
from collections import deque
queue = deque()

queue.append(e)

front = queue.popleft()

front = queue[0]

len(queue)
```

## priority queue

```python
import heapq # 기본적으로 min heap

class Obj:
    def __init__(self, num1, num2):
        self.num1 = num1
        self.num2 = num2
	# min heap이기때문에 less than 조건을 확인, 우선순위 상위로 배치하고 싶으면 True 리턴
    # num1 작은순, num1이 같으면 num2가 큰 순서
    def __lt__(self, other):
        if self.num1 < other.num1: # num1이 작으면 상위
            return True
        elif self.num1 > other.num1:
            return False
        else:
            return self.num2 > other.num2 # num1이 같을 때 num2가 크면 상위
	# 출력해서 확인하기 위함
    def __repr__(self):
        return '{{num1: {}, num2: {}}}'.format(self.num1, self.num2)


hq = []
obj1 = Obj(1,2)
obj2 = Obj(2,1)

heapq.heappush(hq, obj1)
heapq.heappush(hq, obj2)

top = heapq.heappop(hq)

top = hq[0]

# 단순 숫자일 경우에는 -붙인 tupple로 max heap 구현 가능
heapq.heappush(hq, (-num, num))

top = heapq.heapop(hq)[1]

top = hq[0][1]

# 기존 배열이 주어졌을 경우 바로 heap구조로 바꿔서 사용 가능
arr = [5,4,3,2,1]
heapq.heapify(arr) # min heap [1,2,3,5,4]

arr = [1,2,3,4,5]
arr = list(map(lambda e: (-e,e), arr))
heapq.heapify(arr)  # max heap [(-5, 5), (-4, 4), (-3, 3), (-1, 1), (-2, 2)]
```

## sort, sorted

```python
arr = [{num1:1, num2:2},{num1:1, num2:1}]
# num1 내림차순정렬, num1이 같으면 num2 오름차순 정렬
arr.sort(key=lambda e: e['num1'], reverse=True)
arr.sort(key=lambda e: e['num2'])

# priority queue 처럼 __lt__ 정의된 클래스 만들어서 정렬도 가능
obj2 = Obj(2,1)
obj1 = Obj(1,2)
arr = [obj2, obj1]
arr.sort() # [obj1, obj2]

# 원본 arr은 유지한 채로 정렬된 새 배열 리턴
sorted(arr)
```



## string compare

```python
a = 'abc'
b = 'abd'
c = 'abc'
a < b // True
a > b // False
a == c // True
```

## string replace

```python
s = 'HeLlo'
s = ''.join( (s[:2], 'l', s[2+1:]) ) # 'hello'

s = s.replace('L', 'l') # 해당 문자 전체 치환 후 다시 대입 필요함
```

## string reverse

```python
s = 'Hello'
s = s[::-1] # 'olleH'
```

## regular expression

```python
import re

splited = re.compile('[ ,]').split(string) # regex 조건에 맞게 split
```

## upper, lower, caapitalize

```python
string = 'this is a string'
string = string.upper() # 'THIS IS A STRING'
string = string.lower()
```

## string split

```python
string = 'this is a string'
splited = [c for c in string] # '' 로는 split 안됨
splited = string.split(' ')
```



## permutation, combination

```python
from itertools import permutations, combinations
items = ['A', 'B', 'C']

# items의 원소 중 2개만 뽑아서 순열을 만든다. 두 번째 파라미터 없으면 전체에 대하여
for permu in permutations(items, 2):
    # todo...

# items의 원소 중 2개만 뽑아서 조합을 만든다. 두 번째 파라미터 필수
for combi in combinations(items, 2):
    # todo...
```

## sum, min, max

```python
arr = [1,2,3]
sum(arr) # 6
sum([]) # 0

# min, max는 빈 배열에서 호출하면 에러나므로 주의
min(arr) # 1
max(arr) # 3
```
