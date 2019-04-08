while True:
    ab = input()
    a,b = map(int,ab.split())
    if a == 0 and b == 0:
        break
    print(a+b)