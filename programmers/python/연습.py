# 기본 연산자
print(7/3)
print(7//3)
print(7%3)
print(2**3)

# 몫과 나머지
d, m = divmod(7,3)
print('몫 :',d,'나머지 :',  m)

# 형 변환
print(type(3.3))
print(int(3.3))
print(int('10'))
print(str(10))

# 2, 8, 16 진수 포맷
print(0b101)
print(0o10)
print(0xf)

# 출력 진수 포멧 정하기
# a = input()
# if(a[0] == '0'):
#     if(a[0:2] == '0x'):
#         print(int(a[2:], 16))
#     else:
#         print(int(a[1:], 8))

# else:
#     print(int(a))

a, b, c = 10, '20', 30
print(type(a), type(b), type(c))

# swap
a, c = c, a
print(a,b,c)

# variable => None | del
var1 = 10
del var1
# print(var1)
var1 = None
print(var1)

# 입력
# var1 = input() # str형으로 입력
# print(type(var1))

# var1 = int(input()) # int형으로 변환
# print(type(var1))


# input 한줄을 받아서 공백으로 구분하기, str형으로 입력됨
# u, v = input().split()
# print(u,v)
# print(type(u), type(v))

# input 바로 int형으로 받는 방법
# u, v = map(int, input().split())
# print(u,v)
# print(type(u), type(v))

# print 마다 \n 넣기
# a, b, c = map(int, input().split(','))
# print(a,b,c,sep='\n')
# print("\n".join(['hi','by','hehe']))

# print 뒤에 엔터(\n) 없애고 다른 문자 넣기 가능
print(a, end=' ') 
print(b, end='^^')
print(c)

def g(x): return x**2

(a,b,c) = map(g, [1,2,3])
print(a,b,c)

res = list(map(lambda x: x*2, [1,2,3]))
print(res)

# 2차원 배열
# a = [[10, 20], [30, 40], [50, 60]]
# for x, y in a:
#     print(x, y)

# from functools import reduce
# print(reduce(lambda x, y: x+y, [1,2,3]))

wannaEven = [1,2,3,4,5,6,7,8,9,10]
res = list(filter(lambda e: e%2 == 0, wannaEven))
print(res)

# 리스트 만들기
a = []
b = list(range(10))
print(b)

c = list(range(1,5))
print(c)

c = list(range(10,0, -1))
print(c)

# for문으로 문자열 리스트 -> 정수 리스트 변환 및 합
nlist = [int(x) for x in ['10', '20', '30']]
print(nlist)
print(sum(nlist))

var = ['a', 'b', 'c']
for i, val in enumerate(var):
    print(i, val)


# 반복문으로 2차원 배열 만들기
a = ['x' for i in range(3)]
print(a)

a = [[0,0,0] for i in range(3)]
print(a)

a = [[0 for i in range(3)] for i in range(3)]
print(a)

# for문으로 리스트 완성하기
nlist = [int(x) for x in ['10', '20', '30']]
print(sum(nlist))

# 튜플 만들기 ( 튜플은 읽기 전용 리스트 )
c = tuple(range(0,10))
print(c)

# 리스트 두개 합치기
a = [1,2,3]
b = [4,5,6]
print(a, b)
c = a + b
print(c)

# 리스트 같은거 이어 붙이기
c = a*3
print(c)

# 뒤에서부터 세는 인덱스
print(b[-1])

# 인덱스에 해당하는 원소 삭제
del a[1]
print(a)

b = [0,1,2,3,4,5,6,7,8,9]
print(b[0:-1:2]) # 뒤에서 2번째까지만 가져옴, 2칸씩 건너 뛰고
print(b[::2]) # 짝수 번째 인덱스만
print(b[1::2]) # 홀수 번째 인덱스만
print(b[::-1]) # 뒤집기
print(b[4::] + b[0:4:]) # 4번째 인덱스부터 로테이션
print(b[4::-1] + b[len(b):4:-1]) # 4번째 인덱스부터 반대로 로테이션

# sum, min, max, sorted, sorted( , reverse=True)
var = [1,2,3,4,-1,100]

print(sum(var))
print(min(var))
print(max(var))
print(sorted(var))
print(sorted(var, reverse=True))

var = (1,2,3,4,-1,10)
print(min(var))

var = 'EABCD'
# print(sum(var)) // str => int 불가 에러
print(min(var))
print(sorted(var))

# list 뒤에 추가
a = [1,2,3,4,5]
a.append(6)
print(a)

a.extend([7,8])
print(a)

print('역', sorted(a, reverse=True))
print(a)
a.sort(reverse=True)
print(a)
a.reverse()
print(a)


from collections import deque

dq = deque([1,2,3,4])

print(dq[0])
print(dq[-1])
print(len(dq))

dq.append(5)
dq.appendleft(6)

print(dq.pop())
print(dq.popleft())

dq.rotate()
print(list(dq))
dq.rotate()
print(list(dq))

var = [1,2,3]
var[(0//2)%5]